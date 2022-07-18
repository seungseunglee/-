package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2156_포도주시식 {

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
        int[] cnt = new int[N + 1];

        for (int n = 1; n <= Math.min(2, N); n++) {
            dp[n] = dp[n-1] + arr[n];
            cnt[n] = cnt[n-1] + 1;
        }

        for (int n = 3; n <= N; n++) {
            if (cnt[n - 1] == 2) {
                int num1 = dp[n - 1];
                int num2 = dp[n - 2] + arr[n];
                int num3 = dp[n - 3] + arr[n - 1] + arr[n];

                dp[n] = Math.max(Math.max(num1, num2), num3);

                if (dp[n] == num1) {
                    cnt[n] = 0;
                } else if (dp[n] == num2) {
                    cnt[n] = 1;
                } else {
                    cnt[n] = 2;
                }
            } else {
                dp[n] = dp[n - 1] + arr[n];
                cnt[n] = cnt[n - 1] + 1;
            }
        }

        System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);
    }
}
