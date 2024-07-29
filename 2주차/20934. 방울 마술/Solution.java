import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int Test= Integer.parseInt(br.readLine());

        for (int t = 1; t<=Test; t++){
            String[] input = br.readLine().split(" ");
            String cups = input[0];
            int K = Integer.parseInt(input[1]);
            //o가 있는 곳
            int init = cups.indexOf('o');

            double[] probabilities = new double[3];
            probabilities[init] = 1.0;

            //k번
            for (int i = 0; i < K; i++) {
                double[] newProbabilities = new double[3];
                // 동전 앞면
                newProbabilities[0] += probabilities[1] * 0.5;
                newProbabilities[1] += probabilities[0] * 0.5;
                // 동전 뒷면
                newProbabilities[1] += probabilities[2] * 0.5;
                newProbabilities[2] += probabilities[1] * 0.5;

                probabilities = newProbabilities;
            }

            //최대확률 위치찾기
            int maxP = 0;
            for(int i = 0; i < 3; i++){
                if(probabilities[i] > probabilities[maxP]){
                    maxP = i;
                }

            }
            System.out.println("#"+t+ " "+maxP);
        }

        br.close();

    }
}