import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*

N*N
M : 파이어볼
(r,c) : 파이어볼 위치
w : 질량
s : 속력
d : 방향

*/
public class Main {
    static int N, M, K;
    //                 0  1  2  3  4  5  6  7
    static int[] dr = {-1,-1, 0, 1, 1, 1, 0,-1};
    static int[] dc = { 0, 1, 1, 1, 0,-1,-1,-1};


    static class Fireball{
        int r,c,m,s,d;
        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static List<Fireball> fireball;


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        fireball = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireball.add(new Fireball(r, c, m, s, d));

        }

        for(int i =0; i < K; i++){
            moveFireball();
        }

        int result = 0;
        for (Fireball fb : fireball) {
            result += fb.m;
        }
        System.out.println(result);

    }

    static void moveFireball(){
        List<Fireball> newFireballs = new ArrayList<>();
        Map<String, List<Fireball>> positions = new HashMap<>();
        // 위치 이동, 위치 저장
        for(Fireball fb : fireball){
            int cR = (fb.r + dr[fb.d] * fb.s) % N;
            int cC = (fb.c + dc[fb.d] * fb.s) % N;

            //격자판 반대편으로 이동
            if (cR < 0) cR += N;
            if (cC < 0) cC += N;
//            if (cR >= N || cR < 0 || cC >= N || cC < 0) {
//                // 범위 벗어나면 사라짐
//                continue;
//            }

            String pos = cR + " " +cC;

            // pos 위치의 리스트 가져오기
            List<Fireball> list = positions.get(pos);

            // pos 위치에 리스트가 없으면 새로운 ArrayList를 생성하여 맵에 추가
            if (list == null) {
                list = new ArrayList<>();
                positions.put(pos, list);
            }

            // 리스트에 새로운 Fireball 객체를 추가합니다.
            list.add(new Fireball(cR, cC, fb.m, fb.s, fb.d));

        }

        for(List<Fireball> list : positions.values()){
            //fireball이 하나면
            if(list.size() == 1){
                newFireballs.add(list.get(0));
            }//fireball이 여러개면
            else{
                int totalM = 0;
                int totalS = 0;
                boolean allEven = true;
                boolean allOdd = true;

                for (Fireball fb : list) {
                    totalM += fb.m;
                    totalS += fb.s;
                    if (fb.d % 2 == 0) {
                        allOdd = false;
                    } else {
                        allEven = false;
                    }
                }

                int newM = totalM / 5;
                int newS = totalS / list.size();

                //질량이 0이 아니면, 파이어볼 생성
                if (newM > 0) {
                    int[] newDir;
                    if(allEven || allOdd){
                        newDir = new int[]{0,2,4,6};
                    }
                    else{
                        newDir = new int[]{1,3,5,7};
                    }

                    for(int d: newDir){
                        newFireballs.add(new Fireball(list.get(0).r, list.get(0).c, newM, newS, d));
                    }

                }
            }
        }
        fireball = newFireballs;
    }
}