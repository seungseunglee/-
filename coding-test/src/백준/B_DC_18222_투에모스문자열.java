package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_DC_18222_투에모스문자열 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        long n = Long.parseLong(br.readLine());
//        solution(n);

        solution(1); // 0
        solution(2); // 1
        solution(10); // 0
        solution(48); // 1
        solution(47); // 0
    }

    private static long get(long n, long[] len) {
        if (n == 1) {
            return 0;
        }

        for (int i=0; i<len.length; i++) {
            if (n <= len[i]) {
                return 1 - get(n - len[i-1], len);
            }
        }

        return 0;
    }

    public static void solution(long n) {
        long[] len = new long[65]; // 2^64 까지 자리수를 모두 저장해야 10^18자리의 수까지 처리 가능. 2^63은 10^18까지 커버 안됨.

        len[0] = 1;
        for (int i=1; i<len.length; i++) {
            len[i] = len[i-1] * 2;
        }

        System.out.println(get(n, len));
    }
}
