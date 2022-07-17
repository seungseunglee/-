package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1262_알파벳다이아몬드 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        StringTokenizer sb = new StringTokenizer(line);
//
//        int N, R1, C1, R2, C2;
//
//        N = Integer.parseInt(sb.nextToken());
//        R1 = Integer.parseInt(sb.nextToken());
//        C1 = Integer.parseInt(sb.nextToken());
//        R2 = Integer.parseInt(sb.nextToken());
//        C2 = Integer.parseInt(sb.nextToken());

        int N = 5, R1 = 1, C1 = 2, R2 = 2, C2 = 2;

        solution(N, R1, C1, R2, C2);
    }

    public static void solution(int N, int R1, int C1, int R2, int C2) {

        for (int i=0; i<N; i++) {
            for (int j=0; j<N*5; j++) {
                /*
                 * i=0 일 때,
                 * j=4~1 : "."
                 * j=0   : LAST - j
                 *
                 * i=1 일 때,
                 * j=4~2 : "."
                 * j=1~0 : LAST - j
                 *
                 * print
                 * i < j : "."
                 *
                 */

                if (i%N < N - (j%N) - 1) { // i:1 j:
                    System.out.print(".");
                } else {
//                    System.out.print((char) ('a' + (Math.abs((N-1) - j) % N)));
                    System.out.print(Math.abs((N-1) - j) % N);
                }
            }
            System.out.println();
        }

    }
}
