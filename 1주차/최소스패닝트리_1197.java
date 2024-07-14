import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//최소스패닝트리
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //정점의 개수
        int v = Integer.parseInt(st.nextToken());
        //간선의 개수
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            parent[i] = i;
        }

        int[][] edges = new int[e][3];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        //가중치 기준
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));

        int ans = 0;
        for (int i = 0; i < e; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int cost = edges[i][2];

            if (findParent(a) != findParent(b)) {
                union(a, b);
                ans += cost;
            }
        }

        System.out.println(ans);

    }
    public static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = findParent(parent[x]);
            return parent[x];
        }
    }

    public static void union(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        if (pa < pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }
}
