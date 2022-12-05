package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_BFS_7576_토마토 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());

        int[][] tomato = new int[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            tomato[i][0] = -1;
            tomato[i][m + 1] = -1;
        }

        for (int i = 0; i < m + 2; i++) {
            tomato[0][i] = -1;
            tomato[n + 1][i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                tomato[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        solution(m, n, tomato);


//        solution(6, 4, new int[][]{{-1, -1, -1, -1, -1, -1, -1, -1}, {-1, 0, 0, 0, 0, 0, 0, -1}, {-1, 0, 0, 0, 0, 0, 0, -1}, {-1, 0, 0, 0, 0, 0, 0, -1}, {-1, 0, 0, 0, 0, 0, 1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1}}); // 8
//        solution(6, 4, new int[][]{{-1, -1, -1, -1, -1, -1, -1, -1}, {-1, 0, -1, 0, 0, 0, 0, -1}, {-1, -1, 0, 0, 0, 0, 0, -1}, {-1, 0, 0, 0, 0, 0, 0, -1}, {-1, 0, 0, 0, 0, 0, 1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1}}); // -1
//        solution(6, 4, new int[][]{{-1, -1, -1, -1, -1, -1, -1, -1}, {-1, 1, -1, 0, 0, 0, 0, -1}, {-1, 0, -1, 0, 0, 0, 0, -1}, {-1, 0, 0, 0, 0, -1, 0, -1}, {-1, 0, 0, 0, 0, -1, 1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1}}); // 6
//        solution(5, 5, new int[][]{{-1, -1, -1, -1, -1, -1, -1}, {-1, -1, 1, 0, 0, 0, -1}, {-1, 0, -1, -1, -1, 0, -1}, {-1, 0, -1, -1, -1, 0, -1}, {-1, 0, -1, -1, -1, 0, -1}, {-1, 0, 0, 0, 0, 0, -1}, {-1, -1, -1, -1, -1, -1, -1}}); // 14
//        solution(2, 2, new int[][]{{-1, -1, -1, -1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}, {-1, -1, -1, -1}}); // 0

    }

    public static void solution(int m, int n, int[][] tomatoes) {
        final int RIPE = 1, UNRIPE = 0, EMPTY = -1;
        final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int answer = -1;
        int cntTomato = 0, cntRipeTomato = 0;
        boolean[] visited = new boolean[n * m];

        Queue<Tomato> q = new LinkedList<>();

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (tomatoes[y][x] == RIPE) {
                    q.offer(new Tomato(x, y, 0));
                }
                if (tomatoes[y][x] != EMPTY) {
                    cntTomato++;
                }
            }
        }

        while (!q.isEmpty()) {
            Tomato tomato = q.poll();

            for (int[] dir : DIRS) {
                int x = tomato.x + dir[1], y = tomato.y + dir[0];

                if (tomatoes[y][x] == UNRIPE) {
                    tomatoes[y][x] = RIPE;
                    q.offer(new Tomato(x, y, tomato.depth + 1));
                }
            }

            if (!visited[tomato.depth]) {
                visited[tomato.depth] = true;
                answer++;
            }
        }

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (tomatoes[y][x] == RIPE) {
                    cntRipeTomato++;
                }
            }
        }

        System.out.println(cntTomato == cntRipeTomato ? answer : -1);
    }

    static class Tomato {
        int x, y, depth;

        Tomato(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
