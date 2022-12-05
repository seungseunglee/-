package 백준;

import java.io.IOException;

public class B_DP_1309_동물원 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        solution(n);


        solution(4); // 41
    }

    public static void solution(int n) {
        int answer = 0;
        final int div = 9901, empty = 0, left = 1, right = 2;
        int[][] dp = new int[n][3];
        // XX - empty(0)
        // OX - left(1)
        // XO - right(2)

        dp[0][empty] = dp[0][left] = dp[0][right] = 1;

        for (int i=1; i<n; ++i) {
            dp[i][empty] = (dp[i-1][empty] + dp[i-1][left] + dp[i-1][right]) % div;
            dp[i][left] = (dp[i-1][empty] + dp[i-1][right]) % div;
            dp[i][right] = (dp[i-1][empty] + dp[i-1][left]) % div;
        }

        for (int i=0; i<3; ++i) {
            answer += dp[n-1][i];
        }

        answer %= div;

        System.out.println(answer);
    }
}
