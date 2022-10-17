package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_IMP_13335_트럭 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int length = Integer.parseInt(st.nextToken());
//        int weight = Integer.parseInt(st.nextToken());
//
//        int[] trucks = new int[n];
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            trucks[i] = Integer.parseInt(st2.nextToken());
//        }
//
//        solution(n, length, weight, trucks);

        solution(4, 2, 10, new int[]{7, 4, 5, 6}); // 8
        solution(1, 100, 100, new int[]{10}); // 101
        solution(10, 100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}); // 110
        solution(9, 5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}); // 19
    }

    private static void solution(int n, int length, int weight, int[] trucks) {
        Queue<Truck> bridge = new LinkedList<>();
        int truck = 0, timer = 1;
        int weightOnBridge = 0, countOnBridge = 0;

        bridge.offer(new Truck(trucks[truck], timer));
        countOnBridge++;
        weightOnBridge += trucks[truck];

        while (!bridge.isEmpty()) {
            timer++;

            if (bridge.peek().timeIn + length == timer) {
                Truck out = bridge.poll();
                countOnBridge--;
                weightOnBridge -= out.weight;
            }

            if (countOnBridge < length
                    && truck + 1 < n
                    && weightOnBridge + trucks[truck + 1] <= weight) {
                bridge.offer(new Truck(trucks[++truck], timer));
                weightOnBridge += trucks[truck];
                countOnBridge++;
            }
        }

        System.out.println(timer);
    }

    static class Truck {
        int weight, timeIn;

        Truck(int weight, int timeIn) {
            this.weight = weight;
            this.timeIn = timeIn;
        }
    }

}
