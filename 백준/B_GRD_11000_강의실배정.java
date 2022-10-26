package 백준;

import java.io.IOException;
import java.util.Arrays;

public class B_GRD_11000_강의실배정 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[][] classes = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            classes[i][0] = Integer.parseInt(st.nextToken());
//            classes[i][1] = Integer.parseInt(st.nextToken());
//        }
//
//        solution(n, classes);


        solution(3, new int[][]{{1, 3}, {2, 4}, {3, 5}}); // 2
        solution(3, new int[][]{{1, 3}, {2, 3}, {2, 4}, {3, 5}}); // 3
        solution(3, new int[][]{{1, 6}, {2, 5}, {3, 4}}); // 3
        solution(3, new int[][]{{999999999, 1000000000}, {999999998, 999999999}, {1, 999999998}}); // 1
        solution(3, new int[][]{{1, 3}, {3, 5}, {3, 6}}); // 2
    }

    public static void solution(int n, int[][] classes) {
        int answer = 0;
        int room = 0;
        int[][] classTimes = new int[n * 2][2];

        for (int i = 0; i < n; i++) {
            int index = i * 2;

            classTimes[index][0] = classes[i][0];
            classTimes[index][1] = 1;
            classTimes[index + 1][0] = classes[i][1];
            classTimes[index + 1][1] = -1;
        }

        Arrays.sort(classTimes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int[] classTime : classTimes) {
            room += classTime[1];
            answer = Math.max(answer, room);
        }

        System.out.println(answer);
    }
}
