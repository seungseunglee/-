package 백준;

import java.io.IOException;

public class B_GRD_2872_우리집엔도서관이있어 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] nums = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(br.readLine());
//        }
//
//        solution(n, nums);


        solution(3, new int[]{3, 2, 1}); // 2
        solution(4, new int[]{1, 3, 4, 2}); // 2
        solution(3, new int[]{3, 1, 2}); // 2
        solution(5, new int[]{1, 2, 3, 4, 5}); // 0
        solution(5, new int[]{1, 5, 2, 4, 3}); // 4
        solution(8, new int[]{4, 5, 3, 6, 2, 7, 1, 8}); // 3
    }

    public static void solution(int n, int[] nums) {
        int answer = 0;
        int max = nums[0];

        for (int i = 1; i < n; i++) { // nums 탐색
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < max && nums[i] > answer) {
                answer = nums[i];
            }
        }

        System.out.println(answer);
    }

}
