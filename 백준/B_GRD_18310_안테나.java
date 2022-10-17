package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_GRD_18310_안테나 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] houses = new int[n];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            houses[i] = Integer.parseInt(st.nextToken());
//        }
//
//        solution(n, houses);


        solution(4, new int[]{5, 1, 7, 9}); // 5
        solution(4, new int[]{3, 1, 7, 9}); // 3
        solution(9, new int[]{1, 1, 1, 1, 1, 1, 1, 7, 9}); // 1
        solution(2, new int[]{1, 90}); // 1
        solution(3, new int[]{1, 10, 10}); // 10
        solution(3, new int[]{1, 1, 10}); // 1
        solution(5, new int[]{1, 7, 8, 9, 10}); // 8
    }

    public static void solution(int n, int[] houses) {
        int answer = houses[0];
        long diff, minDiff;
        long left = 0, right = 0;

        Arrays.sort(houses);

        for (int i = 1; i < n; i++) {
            right += houses[i] - houses[0];
        }

        minDiff = right;

        for (int i = 1; i < n; i++) {
            left = left + (long) (houses[i] - houses[i - 1]) * i;
            right = right - (long) (houses[i] - houses[i - 1]) * (n - i);
            diff = left + right;

            if (minDiff > diff) {
                answer = houses[i];
                minDiff = diff;
            }
        }

        System.out.println(answer);
    }
}
