package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_GRD_1461_도서관 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] books = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            books[i] = Integer.parseInt(st2.nextToken());
        }

        solution(n, m, books);


        solution(7, 2, new int[]{-37, 2, -6, -39, -29, 11, -28}); // 131
        solution(8, 3, new int[]{-18, -9, -4, 50, 22, -26, 40, -45}); // 158
        solution(6, 2, new int[]{3, 4, 5, 6, 11, -1}); // 29
        solution(1, 50, new int[]{1}); // 1
        solution(6, 2, new int[]{-3, -4, -5, -6, -11, 1}); // 29
    }

    public static void solution(int n, int m, int[] books) {
        int answer = 0;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int book : books) {
            if (book > 0) {
                positive.add(book);
            } else {
                negative.add(book);
            }
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        int dividendPositiveSize = (int) Math.ceil(positive.size() / (double) m);
        int dividendNegativeSize = (int) Math.ceil(negative.size() / (double) m);

        for (int i = 0; i < dividendPositiveSize; i++) {
            int step = Math.abs(positive.get(i * m));
            answer += step * 2;
        }

        for (int i = 0; i < dividendNegativeSize; i++) {
            int step = Math.abs(negative.get(i * m));
            answer += step * 2;
        }

        if (positive.size() > 0 && negative.size() > 0) {
            answer = Math.min(answer - Math.abs(positive.get(0)), answer - Math.abs(negative.get(0)));
        } else if (positive.size() > 0) {
            answer -= Math.abs(positive.get(0));
        } else {
            answer -= Math.abs(negative.get(0));
        }

        System.out.println(answer);
    }
}
