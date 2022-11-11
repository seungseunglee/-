package 백준;

import java.io.IOException;
import java.util.PriorityQueue;

public class B_DS_15903_카드합체놀이 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        int[] cards = new int[n];
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            cards[i] = Integer.parseInt(st2.nextToken());
//        }
//
//        solution(n, m, cards);


        solution(3, 1, new int[]{3, 2, 6}); // 16
        solution(4, 2, new int[]{4, 2, 3, 1}); // 19
    }

    public static void solution(int n, int m, int[] cards) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (long card: cards) {
            pq.offer(card);
        }

        for (int i=0; i<m; i++) {
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(a + b);
            pq.offer(a + b);
        }

        for (long card: pq) {
            answer += card;
        }

        System.out.println(answer);
    }
}
