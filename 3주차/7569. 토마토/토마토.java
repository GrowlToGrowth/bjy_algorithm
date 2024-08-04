import java.io.IOException;
import java.util.*;


/*
bfs
*/
public class Main {
    static int m,n,h;
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<int[]> q = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0, 0 ,0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        box = new int[h][n][m];
        visited = new boolean[h][n][m];
        //다 익었는지 확인하는 변수
        boolean all = true;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    box[i][j][k] = sc.nextInt();
                    if(box[i][j][k] == 1 || box[i][j][k] == -1) {
                        visited[i][j][k] = true;
                        if(box[i][j][k] == 1){
                            q.add(new int[]{i, j, k});
                        }
                    }

                    if(box[i][j][k] == 0){
                        all = false;
                    }
                }
            }
        }
        if(all){
            System.out.println(0);
        }
        else {
            bfs();
            answer();
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int z = temp[0];
            int y = temp[1];
            int x = temp[2];
            for(int i = 0; i < 6; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                int cz = z + dz[i];

                if(0 <= cx && cx < m && 0 <= cy && cy < n && 0 <= cz && cz < h && !visited[cz][cy][cx] && box[cz][cy][cx] == 0){
                    visited[cz][cy][cx] = true;
                    box[cz][cy][cx] = box[z][y][x] + 1;
                    q.add(new int[]{cz, cy, cx});
                }
            }
        }
    }

    static void answer(){
        int result = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(box[i][j][k] == 0) {
                        //익지않는 토마토가 있는 경우
                        System.out.println(-1);
                        return;
                    }
                    if(box[i][j][k] > result) {
                        result = box[i][j][k];
                    }

                }
            }
        }
        //순차대로 익었을 경우 , 1부터 시작했으므로 하루를 빼야 함.
        System.out.println(result-1);
    }
}