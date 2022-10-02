package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_GRD_1105_팔 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int l = Integer.parseInt(st.nextToken());
//        int r = Integer.parseInt(st.nextToken());
//
//        solution(l, r);


        solution(1, 10); // 0
        solution(1, 880); // 0
        solution(88, 88); // 2
        solution(800, 899); // 1
        solution(8808, 8880); // 2
        solution(800, 8000); // 0
    }


    public static void solution(int l, int r) {
        int diff = r - l;
        int digit = countDigit(diff);
        int tailL = l / (int) Math.pow(10, digit);
        int tailR = r / (int) Math.pow(10, digit);

        System.out.println(Math.min(countEight(tailL), countEight(tailR)));
    }

    private static int countDigit(int n) {
        int cnt = 0;

        while (n != 0) {
            cnt++;
            n /= 10;
        }

        return cnt;
    }

    private static int countEight(int n) {
        int cnt = 0;

        while (n != 0) {
            if (n % 10 == 8) {
                cnt++;
            }
            n /= 10;
        }

        return cnt;
    }
}
