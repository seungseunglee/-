package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_DS_1302_베스트셀러 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] books = new String[N];
        for (int i=0; i<N; i++) {
            books[i] = br.readLine();
        }

        solution(N, books);
    }

    public static void solution(int N, String[] books) {
        Map<String, Integer> hm = new HashMap<>();

        for (String book: books) {
            hm.put(book, hm.getOrDefault(book, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey()); // 제목: 내림차순
            }
            return o2.getValue().compareTo(o1.getValue()); // 매출: 오름차순
        });

        System.out.print(list.get(0).getKey());
    }
}
