package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_DP_11060_점프점프 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        StringTokenizer sb = new StringTokenizer(line);

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(sb.nextToken());
        }

        solution(N, arr);
    }

    public static void solution(int N, int[] arr) {

        final int INF = 1001;
        int[] dp = new int[N+1];

        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j] >= i - j) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        if (dp[N-1] == INF) System.out.println("-1");
        else System.out.println(dp[N-1]);
    }
}
