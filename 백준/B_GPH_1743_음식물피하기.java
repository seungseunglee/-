package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_GPH_1743_음식물피하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] trash = new int[k][2];

        for (int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            trash[i][0] = Integer.parseInt(st2.nextToken());
            trash[i][1] = Integer.parseInt(st2.nextToken());
        }

        solution(n, m, k, trash);

//        solution(3, 4, 5, new int[][]{{3, 2}, {2, 2}, {3, 1}, {2, 3}, {1, 1}}); // 4
//        solution(3, 4, 7, new int[][]{{1, 3}, {2, 4}, {3, 2}, {2, 2}, {3, 1}, {2, 3}, {1, 1}}); // 6
    }

    public static void solution(int n, int m, int k, int[][] trash) {
        int answer = 0;
        boolean[][] hallway = new boolean[n + 2][m + 2];
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < k; i++) {
            hallway[trash[i][0]][trash[i][1]] = true;
        }

        for (int i = 0; i < k; i++) {
            int count = 0;
            Queue<Pos> q = new LinkedList<>();

            int posX = trash[i][1];
            int posY = trash[i][0];

            if (hallway[posY][posX]) {
                q.offer(new Pos(posX, posY));
                hallway[posY][posX] = false;
            }

            while (!q.isEmpty()) {
                Pos pos = q.poll();
                count++;

                for (int[] dir : dirs) {
                    int newPosX = pos.x + dir[1];
                    int newPosY = pos.y + dir[0];

                    if (hallway[newPosY][newPosX]) {
                        hallway[newPosY][newPosX] = false;
                        q.offer(new Pos(newPosX, newPosY));
                    }
                }
            }

            answer = Math.max(count, answer);
        }

        System.out.println(answer);
    }

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
