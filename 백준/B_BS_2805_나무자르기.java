package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_BS_2805_나무자르기 {

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st1.nextToken());
//        int m = Integer.parseInt(st1.nextToken());
//
//        int[] trees = new int[n];
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            trees[i] = Integer.parseInt(st2.nextToken());
//        }
//
//        solution(n, m, trees);


        solution(4, 7, new int[]{20, 15, 10, 17}); // 15
        solution(5, 20, new int[]{4, 42, 40, 26, 46}); // 36
        solution(5, 21, new int[]{4, 42, 40, 26, 46}); // 35
        solution(5, 25, new int[]{5, 5, 5, 5, 5}); // 0
        solution(5, 1, new int[]{5, 5, 5, 5, 5}); // 4
        solution(5, 2000000000, new int[]{1000000000, 1000000000, 1000000000, 1000000000, 1000000000}); // 600000000
    }

    public static void solution(int n, int m, int[] trees) {
        int answer = 0;
        int high = 1000000001, low = 1, mid;

        while (high >= low) {
            mid = (high + low) / 2;

            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (mid < trees[i]) {
                    sum += trees[i] - mid;
                }
            }

//            System.out.print("(" + sum + ")" + high + " " + mid + " " + low + " ");
            if (sum < m) {
                high = mid - 1;
            } else {
                answer = mid;
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
