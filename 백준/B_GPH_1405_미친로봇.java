package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_GPH_1405_미친로봇 {
    static double answer;
    static boolean[][] visit;
    static double[] probabilities;
    static int N;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // (x,y), 동서남북

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int east = Integer.parseInt(st.nextToken());
//        int west = Integer.parseInt(st.nextToken());
//        int south = Integer.parseInt(st.nextToken());
//        int north = Integer.parseInt(st.nextToken());
//
//        solution(n, east, west, south, north);


        solution(2, 25, 25, 25, 25); // 0.75 (= (1+1+1+1)/4^2)
        solution(1, 25, 25, 25, 25); // 1.0
        solution(7, 50, 0, 0, 50); // 1.0
        solution(14, 50, 50, 0, 0); // 0.0001220703125
        solution(14, 25, 25, 25, 25); // 0.008845493197441101
        solution(3, 25, 25, 25, 25); // 0.5625
    }


    public static void solution(int n, int east, int west, int south, int north) {
        answer = 0;
        visit = new boolean[n * 2 + 1][n * 2 + 1];
        probabilities = new double[]{east / 100.0, west / 100.0, south / 100.0, north / 100.0};
        N = n;

        move(n, n, 0, 1);
        System.out.println(answer);
    }

    private static void move(int curX, int curY, int depth, double probability) {
        if (visit[curY][curX]) {
            return;
        }

        if (depth == N) {
            answer += probability;
            return;
        }

        for (int i = 0; i < 4; i++) {
            visit[curY][curX] = true;
            move(curX + dir[i][0], curY + dir[i][1], depth + 1, probability * probabilities[i]);
            visit[curY][curX] = false;
        }

    }
}
