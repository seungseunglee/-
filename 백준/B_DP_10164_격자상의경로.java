package 백준;

import java.io.IOException;

public class B_DP_10164_격자상의경로 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        solution(N, M, K);

        solution(3, 5, 8);
        solution(7, 11, 0);
        solution(7, 11, 76);
    }

    public static void solution(int n, int m, int k) {

        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        int kk = k == 0 ? n * m : k;
        int kn = kk % m == 0 ? kk / m : kk / m + 1;
        int km = kk % m == 0 ? m : kk % m;

        int startN = 1, startM = 1;
        int lastN = kn, lastM = km;

        while (true) {

            for (int i = startN; i < lastN; i++) {
                dp[i][startM - 1] = 1;
            }
            for (int i = startM; i < lastM; i++) {
                dp[startN - 1][i] = 1;
            }

            for (int i = startN; i < lastN; i++) {
                for (int j = startM; j < lastM; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            if (lastN == n && lastM == m) {
                break;
            }

            startN = kn;
            startM = km;

            lastN = n;
            lastM = m;
        }

        if (k == 0) {
            System.out.println(dp[n - 1][m - 1]);
        } else {
            System.out.println(dp[kn - 1][km - 1] * dp[n - 1][m - 1]);
        }
    }
}
