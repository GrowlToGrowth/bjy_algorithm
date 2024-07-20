//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 1; i <= t; ++i) {
            String S = br.readLine();
            String E = br.readLine();

            /*
            S의 제일 뒤에 X를 붙인다
            S를 뒤집은 다음 제일 뒤에 Y을 붙인다.
            ->
            E에서 맨뒤 X를 지운다
            or
            E에서 Y를 지우고, 뒤집는다.
             */

            if(IsTransform(S,E)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
        br.close();
    }
    public static boolean IsTransform(String s, String e){
        StringBuilder sb = new StringBuilder(e);

        while(sb.length() > s.length()){
            //X면 지우기
            if (sb.charAt(sb.length() - 1) == 'X') {
                sb.deleteCharAt(sb.length() - 1);
            }
            //Y면 지우고, 뒤집기
            else if (sb.charAt(sb.length() - 1) == 'Y') {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }

        return sb.toString().equals(s);
    }

}
