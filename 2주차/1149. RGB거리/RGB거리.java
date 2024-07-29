import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

/*
1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
==
옆집과 색이 같으면 안된다.
위아래와 색이 같으면 안된다.
->
DP로 i+1 집 값에 가능한 i집 값의 최솟값을 더해가며 진행
->
마지막에 N번째 집 중에서 가장 작은 값
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] houses = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            houses[i][0] = min(houses[i-1][1], houses[i-1][2]) + houses[i][0];
            houses[i][1] = min(houses[i-1][0], houses[i-1][2]) + houses[i][1];
            houses[i][2] = min(houses[i-1][0], houses[i-1][1]) + houses[i][2];
        }
        System.out.println(min(min(houses[n-1][0], houses[n-1][1]), houses[n-1][2]));


    }
}