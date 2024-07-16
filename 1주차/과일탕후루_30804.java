import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        //탕후루 꽂힌 순서
        int[] fruits = new int[n];
        for(int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(findMaxFruits(fruits,n));
        //과일별 갯수
        // int[] count = new int[10];
        // for(int i = 0;i<n; i++) {
        // 	count[fruits[i]] += 1;
        // }

    }
    public static int findMaxFruits(int[] fruits, int n){
        Map<Integer,Integer> countMap = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;
        while(right < n){
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right],0)+ 1);
            while(countMap.size() > 2){
                countMap.put(fruits[left], countMap.get(fruits[left])-1);
                if(countMap.get(fruits[left])==0){
                    countMap.remove(fruits[left]);
                }
                left+=1;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right+=1;
        }


        return maxLen;
    }
}
