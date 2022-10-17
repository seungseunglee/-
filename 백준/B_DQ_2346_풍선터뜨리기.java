package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_DQ_2346_풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] balloons = new int[n];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            balloons[i] = Integer.parseInt(st.nextToken());
//        }
//
//        solution(n, balloons);


        solution(5, new int[]{3, 2, 1, -3, -1}); // 1 4 5 3 2
    }

    public static void solution(int n, int[] balloons) {
        boolean[] visited = new boolean[n];
        int cnt = 0;
        int removed = 0;

        while (true) {
            System.out.print((removed + 1) + " ");

            visited[removed] = true;
            cnt++;

            if (cnt >= n) {
                break;
            }

            int move = balloons[removed];
            int dir = move < 0 ? -1 : 1;

            while (move != 0) {
                removed = (removed + dir + n) % n;
                if (!visited[removed]) {
                    move -= dir;
                }
            }
        }
    }
}
