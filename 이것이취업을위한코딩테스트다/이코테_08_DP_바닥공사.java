package 이것이취업을위한코딩테스트다;

public class 이코테_08_DP_바닥공사 {

    public static void main(String[] args) {
        int N = 5;
        solution(N);
    }

    public static void solution(int N) {
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;
        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 796796;
        }

        System.out.println(dp[N]);


    }
}
