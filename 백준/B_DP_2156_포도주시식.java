package 백준;

import java.io.IOException;
import java.util.Arrays;

public class B_DP_2156_포도주시식 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N + 1];
//
//        for (int i=1; i<=N; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        solution(N, arr);

        solution(6, new int[]{0, 6, 10, 13, 9, 8, 1});
    }

    public static void solution(int N, int[] arr) {
        int[] dp = new int[N + 1];

        for (int n = 1; n <= Math.min(2, N); n++) {
            dp[n] = dp[n-1] + arr[n];
        }

        for (int n = 3; n <= N; n++) {
            int num1 = dp[n - 1];
            int num2 = dp[n - 2] + arr[n];
            int num3 = dp[n - 3] + arr[n - 1] + arr[n];

            dp[n] = Math.max(Math.max(num1, num2), num3);
        }

        System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);
    }
}
