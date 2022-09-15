package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_BS_10815_숫자카드 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[][] input = new int[2][];
//
//        for (int i=0; i<2; i++) {
//            int n = Integer.parseInt(br.readLine());
//            input[i] = new int[n];
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                input[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        solution(input[0], input[1]);


        solution(new int[]{6, 3, 2, 10, -10}, new int[]{10, 9, -5, 2, 3, 4, 5, -10}); // 1 0 0 1 1 0 0 1
    }


    public static void solution(int[] yours, int[] mine) {
        final int TRUE = 1, FALSE = 0;
        int[] answer = new int[mine.length];
        Arrays.sort(yours);

        for (int i=0; i<mine.length; i++) {
            if (binarySearch(yours, mine[i])) {
                answer[i] = TRUE;
            } else {
                answer[i] = FALSE;
            }
        }

        for (int i=0; i<answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }


}
