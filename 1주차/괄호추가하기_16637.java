
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    연산자 우선순위 동일, 수식은 왼->오
    최댓값 구하기, 최댓값구하기

    1. 숫자, 연산자 나누기
    2. 각 연산자별 나누어서 재귀
    3. 최댓값 저장
 */

public class Main {
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> numbers = new ArrayList<Integer>();
    static ArrayList<Character> op = new ArrayList<Character>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n : 수식의 길이
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();


        char[] charArr = str.toCharArray();
        //연산자 나누기
        for(int i = 0; i < n; i++){
            if (i % 2 != 0) {
                op.add(charArr[i]);
            }
            else{
                numbers.add(Integer.parseInt(String.valueOf(charArr[i])));
            }
        }


        recursion(0, numbers.get(0));
        System.out.println(max);

    }

    static void recursion(int i, int sum){
        //연산자가 없으면
        if(i >= op.size()){
            max = Math.max(max, sum);
            return;
        }

        //괄호 없을 때,
        int result = cal(sum, numbers.get(i+1),op.get(i));
        recursion(i+1, result);

        //괄호가 있을 때,
        if(i+1 <op.size()){
            int temp = cal(numbers.get(i+1), numbers.get(i+2), op.get(i+1));
            int temp_result = cal(sum, temp, op.get(i));
            recursion(i+2, temp_result);
        }
    }

    static int cal(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new IllegalArgumentException("연산자 다시 확인 : "+ op);
        }
    }

}
