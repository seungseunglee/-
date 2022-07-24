package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_DS_7785_회사에있는사람 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<String>> records = new ArrayList<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<String> record = new ArrayList<>();
            record.add(st.nextToken());
            record.add(st.nextToken());

            records.add(record);
        }

        solution(N, records);
    }

    public static void solution(int N, List<List<String>> records) {

        Map<String, Boolean> hm = new HashMap<>();

        for (List<String> record: records) {
            String name = record.get(0);
            if (record.get(1).equals("enter")) {
                hm.put(name, Boolean.TRUE);
            } else {
                hm.remove(name);
            }
        }

        List<Map.Entry<String, Boolean>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getKey().compareTo(o1.getKey())); // 오름차순

        for (Map.Entry<String, Boolean> entry: list) {
            System.out.println(entry.getKey());
        }

    }
}
