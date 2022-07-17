package 이것이취업을위한코딩테스트다;

public class 이코테_DP_개미전사 {

    public static void main(String[] args) {
        int N = 4;
        int[] arr = {1, 3, 1, 5};

        solution(N, arr);
    }

    public static void solution(int N, int[] arr) {

        int[] dp = new int[100];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i=2; i<N; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }

        System.out.println(dp[N-1]);
    }
}
