import java.util.Scanner;

public class Main{
	
	static int[][] graph;
	static boolean[] visited;
	static int target, result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//전체 사람 수
		int n = Integer.parseInt(sc.nextLine());
		//이 2명의 관계를 구하라
		int[] mans = new int[2];
		
		result = -1;
		String arr[];
		arr = sc.nextLine().split(" ");

		for(int i = 0 ; i<2; i++){
			mans[i] = Integer.parseInt(arr[i]);
		}
		
		int m = Integer.parseInt(sc.nextLine());

		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i = 0 ; i < m; i++){
			arr = sc.nextLine().split(" ");
			int x =Integer.parseInt(arr[0]);
			int y =Integer.parseInt(arr[1]);
			graph[x][y] = 1;
			graph[y][x] = 1;

		}
		target = mans[1];
		dfs(mans[0],0);
		System.out.println(result);
		sc.close();
	}

	static void dfs(int now, int depth ){
		visited[now] = true;

		// 목표 값에 도달하면 끝
		if (now == target) {
			result = depth;
			return;
		}

		for (int i = 1; i < graph.length; i++) {
			if (graph[now][i] == 1 && !visited[i]) {
				dfs(i, depth + 1);
			}
		}
	}
}
