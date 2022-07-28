package 이것이취업을위한코딩테스트다;

import java.util.Arrays;

public class 이코테_08_DP_효율적인화폐구성 {

    public static void main(String[] args) {
        int[] N = {2, 3};
        int[] M = {15, 4}; // 5, -1
        int[][] arr = {{2, 3}, {3, 5, 7}};

        for (int i=0; i<N.length; i++) {
            solution(N[i], M[i], arr[i]);
        }
    }

    public static void solution(int n, int m, int[] arr) {
        /*
         * N: 화폐 종류 개수
         * M: 가치 합
         * arr: 화폐 종류
         */

        final int INF = 10001;
        int[] dp = new int[m+1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i=0; i<n; i++) {
            for (int j=arr[i]; j<=m; j++) {
                if (dp[j - arr[i]] != INF) {
                    dp[j] = Math.min(dp[j], dp[j-arr[i]] + 1);
                }
            }
        }
        if (dp[m] == INF) System.out.println("-1");
        else System.out.println(dp[m]);
    }
}
