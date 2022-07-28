package 이것이취업을위한코딩테스트다;

public class 이코테_08_DP_1로만들기 {
    public static void main(String[] args) {
        int N = 26;
        solution(N);
    }

    public static void solution(int N) {

        int[] dp = new int[30001];

        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            } else if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i/5]+1);
            }
        }

        System.out.println(dp[N]);
    }
}
