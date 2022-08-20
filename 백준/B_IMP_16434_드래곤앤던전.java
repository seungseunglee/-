package 백준;

import java.io.IOException;

public class B_IMP_16434_드래곤앤던전 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken()); // 방의 개수
//        int H = Integer.parseInt(st.nextToken()); // 용사의 초기 공격력
//        int[][] rooms = new int[N][3];
//        for (int i=0; i<N; i++) {
//            st = new StringTokenizer(br.readLine());
//            rooms[i][0] = Integer.parseInt(st.nextToken()); // 1:몬스터, 2:용사
//            rooms[i][1] = Integer.parseInt(st.nextToken()); // 공격력
//            rooms[i][2] = Integer.parseInt(st.nextToken()); // 생명력
//        }
//        solution(N, H, rooms);


        solution(3, 3, new int[][]{{1, 1, 20}, {2, 3, 10}, {1, 3, 100}}); // 49
        solution(1, 1, new int[][]{{1, 1000000, 1000000}}); // 999,999,000,001
        solution(3, 3, new int[][]{{1, 3, 100}, {2, 3, 10}, {1, 1, 20}}); // 100
        solution(3, 3, new int[][]{{1, 3, 100}, {2, 3, 2}, {1, 1, 20}}); // 101
        solution(2, 3, new int[][]{{1, 3, 100}, {1, 1, 20}}); // 118
    }


    public static void solution(int N, int H, int[][] rooms) {
        long warrior_hp = 0;
        long warrior_atk = H;
        long warrior_heal = 0;
        int atk, hp;

        for (int i=0; i<rooms.length; i++) {
            int[] room = rooms[i];
            atk = room[1];
            hp = room[2];

            if (room[0] == 1) {
                long num = hp / warrior_atk;
                num += hp % warrior_atk == 0 ? -1 : 0;
                num *= atk;

                if (warrior_heal > 0) {
                    if (warrior_heal < num) {
                        num -= warrior_heal;
                        warrior_heal = 0;
                        warrior_hp += num;
                    } else {
                        warrior_heal -= num;
                    }
                } else {
                    warrior_hp += num;
                }
            } else {
                warrior_atk += atk;
                warrior_heal += hp;
            }
        }

        System.out.println(warrior_hp + 1);
    }
}