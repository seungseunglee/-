package 프로그래머스;

import java.util.Arrays;

public class P_KthNumber {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int cnt = 0;
        answer = new int[commands.length];


        for (int[] command: commands) {
            int[] tmpArr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(tmpArr);
            answer[cnt++] = tmpArr[command[2] - 1];

            System.out.println(Arrays.toString(command));
            System.out.println(Arrays.toString(tmpArr));
            System.out.println(Arrays.toString(answer));
            System.out.println("-------------------");
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
