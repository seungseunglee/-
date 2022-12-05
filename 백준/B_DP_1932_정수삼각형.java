package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_DP_1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n+1][];

        triangle[0] = new int[2];

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            triangle[i] = new int[i+2];
            for (int j=1; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(n, triangle);


//        solution(5, new int[][]{
//                {0, 0},
//                {0, 7, 0},
//                {0, 3, 8, 0},
//                {0, 8, 1, 0, 0},
//                {0, 2, 7, 4, 4, 0},
//                {0, 4, 5, 2, 6, 5, 0},
//        }); // 30
    }

    public static void solution(int n, int[][] triangle) {
        int answer = 0;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                answer = Math.max(answer, triangle[i][j]);
            }
        }

        System.out.println(answer);
    }
}
