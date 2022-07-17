package 프로그래머스;

import java.util.*;

class P_Failure {

    public static void main(String[] args) {
        int[] n= {5,4};
        int[][] lost = {{2, 1, 2, 6, 2, 4, 3, 3},{4,4,4,4,4}};

        P_Failure clothes = new P_Failure();
        for (int i=0; i<n.length; i++) {
            System.out.println(Arrays.toString(clothes.solution(n[i], lost[i])));
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Double, Integer> failure = new HashMap<Double, Integer>();
        double cnt = 0.0;

        // N = 5
        // [2, 1, 2, 6, 2, 4, 3, 3]	-> [1, 2, 2, 2, 3, 3, 4, 6]

        for (int i=1; i<=N; i++) {
            failure.put(0.0, i);
        }

        Arrays.sort(stages);
        for (int i=stages.length-1; i>=0; i--) {
            cnt += 1;
            if (i == 0 || (stages[i] <= N && stages[i-1] < stages[i])) {
                failure.put((cnt / (stages.length - i)), stages[i]);
                cnt = 0.0;
            }
        }
        System.out.println(failure);

        List<Double> keys = new ArrayList<>(failure.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        int i=0;
        for (Double key: keys) {
            answer[i++] = failure.get(key);
        }

        return answer;
    }
}