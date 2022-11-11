package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_GPH_3182_한동이는공부가하기싫어 {
    static int answer = 0;
    static int maxCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        solution(n, nums);


//        solution(3, new int[]{0, 3, 3, 1}); // 2
//        solution(4, new int[]{0, 2, 3, 4, 1}); // 1
//        solution(6, new int[]{0, 2, 3, 4, 3, 1, 1}); // 5
    }

    public static void solution(int n, int[] nums) {
        boolean[] visited = new boolean[n + 1];

        for (int i=1; i<=n; i++) {
            dfs(visited, nums, i, i, 0);
        }

        System.out.println(answer);
    }

    public static void dfs(boolean[] visited, int[] nums, int start, int idx, int cnt) {
        if (visited[idx]) {
            if (maxCnt < cnt) {
                maxCnt = cnt;
                answer = start;
            }
            return;
        }

        visited[idx] = true;
        dfs(visited, nums, start, nums[idx], cnt + 1);
        visited[idx] = false;
    }
}
