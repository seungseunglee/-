package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_GPH_17204_죽음의게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n+1];

        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        solution(k, nums);


        solution(3, new int[]{1, 3, 2, 1, 4}); // 2
        solution(2, new int[]{1, 3, 5, 4, 0, 2}); // -1
    }


    public static void solution(int k, int[] nums) {
        int answer = 1;

        boolean[] visit = new boolean[nums.length + 1];

        int point = nums[0];
        visit[point] = true;

        while (point != k) {
            point = nums[point];

            if (visit[point]) {
                answer = -1;
                break;
            }

            visit[point] = true;
            answer++;
        }

        System.out.println(answer);
    }
}
