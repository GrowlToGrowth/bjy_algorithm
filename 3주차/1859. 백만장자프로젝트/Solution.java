
import java.util.Scanner;

/*
 *  1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
    2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
	3. 판매는 얼마든지 할 수 있다.

	->
	다음날 보다 싸면 무조건 사긴해야댐
	->
	최대값일 때 팔아야됨
	->
	뒤에서 부터 최댓값을 설정하고, 역순으로 이익 구하기
*/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int[] prices = new int[n];

            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
            }

            long money = 0;
            int maxPrice = 0;

            // 뒤에서부터 최대값 구하기
            for (int i = n - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                }
                money += maxPrice - prices[i];
            }

            System.out.println("#" + tc + " " + money);
        }

        sc.close();
    }
}

// 		Scanner sc = new Scanner(System.in);

// 		int t = sc.nextInt();
// 		for (int tc = 1; tc <=t; tc++){
// 			int money = 0;
// 			int n = sc.nextInt();
// 			int[] fuel = new int[n];

// 			for(int i = 0; i<n;i++){
// 				fuel[i] = sc.nextInt();
// 			}

// 			int today = 0;
// 			int maxindex = 0;
// 			while(today < n){
// 				int sell = 0;
// 				for(int i = today; i<n;i++){
// 					if(sell <= fuel[i]){
// 						sell = fuel[i];
// 						maxindex = i;
// 					}
// 				}
// 				int cnt = 0;
// 				for (int i = today; i <= maxindex; i++){
// 					if(sell < fuel[i]){
// 						money -= fuel[i];
// 						cnt +=1;
// 					}
// 					else if (sell == i){
// 						money += cnt*fuel[i];
// 					}
// 				}
// 				today = maxindex+1;
// 			}

// 			System.out.println("#"+tc+" "+money);
// 		}
// 		sc.close();

// 	}

// }
