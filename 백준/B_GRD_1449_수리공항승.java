package 백준;

import java.io.IOException;
import java.util.Arrays;

public class B_GRD_1449_수리공항승 {

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st1.nextToken());
//        int l = Integer.parseInt(st1.nextToken());
//
//        int[] pipes = new int[n];
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            pipes[i] = Integer.parseInt(st2.nextToken());
//        }
//
//        solution(n, l, pipes);


        solution(4, 2, new int[]{1, 2, 100, 101}); // 2
        solution(4, 3, new int[]{1, 2, 3, 4}); // 2
        solution(3, 1, new int[]{3, 2, 1}); // 3
    }

    public static void solution(int n, int l, int[] pipes) {
        int answer = 1;
        int tape = l;

        Arrays.sort(pipes);

        for (int i=1; i<n; i++) {
            if (tape > pipes[i] - pipes[i-1]) {
                tape -= pipes[i] - pipes[i-1];
            } else {
                answer++;
                tape = l;
            }
        }

        System.out.println(answer);

    }
}
