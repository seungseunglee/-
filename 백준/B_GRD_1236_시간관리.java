package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_GRD_1236_시간관리 {

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[][] tasks = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            tasks[i][0] = Integer.parseInt(st.nextToken());
//            tasks[i][1] = Integer.parseInt(st.nextToken());
//        }
//
//        solution(n, tasks);


        solution(4, new int[][]{{3, 5}, {8, 14}, {5, 20}, {1, 16}}); // 2
        solution(5, new int[][]{{3, 5}, {8, 14}, {5, 20}, {1, 16}, {5, 16}}); // -1
        solution(5, new int[][]{{3, 5}, {8, 14}, {5, 17}, {1, 14}, {5, 16}}); // -1
        solution(5, new int[][]{{3, 13}, {8, 22}, {5, 25}, {1, 22}, {5, 24}}); // 3
        solution(1, new int[][]{{3, 5}}); // 2
    }

    public static void solution(int n, int[][] tasks) {
        int answer = 1000000;

        Arrays.sort(tasks, (o1, o2) -> {
            if (o1[1] == o2[1]) { // deadline
                return o2[0] - o1[0]; // duration
            }
            return o2[1] - o1[1];
        });

        for (int[] task: tasks) {
            if (answer <= task[1]) {
                answer -= task[0];
            } else {
                answer = task[1] - task[0];
            }
        }

        if (answer < 0) {
            answer = -1;
        }

        System.out.println(answer);
    }
}
