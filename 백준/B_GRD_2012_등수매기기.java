package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_GRD_2012_등수매기기 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] ranks = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            ranks[i] = Integer.parseInt(br.readLine());
//        }
//
//        solution(n, ranks);


        solution(5, new int[]{1, 5, 3, 1, 2}); // 3
    }

    public static void solution(int n, int[] ranks) {
        int answer = 0;

        Arrays.sort(ranks);

        for (int i = 1; i <= n; i++) {
            answer += Math.abs(ranks[i - 1] - i);
        }

        System.out.println(answer);
    }
}
