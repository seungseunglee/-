package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_IMP_1213_팰린드롬만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        solution(name);
    }

    public static void solution(String name) {

        Map<String, Integer> hm = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int i=0; i<name.length(); i++) {
            String ch = Character.toString(name.charAt(i));
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        String oddStr = "";
        int oddCnt = 0;
        for (Map.Entry<String, Integer> entry: hm.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddCnt++;
                oddStr = entry.getKey();
            }

            if (oddCnt > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        if (name.length() % 2 == 0 && oddCnt != 0) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        hm.replaceAll((k, v) -> v / 2);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getKey().compareTo(o2.getKey())); // 오름차순

        for (Map.Entry<String, Integer> entry: list) {
            for (int i=0; i<entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        StringBuffer sb = new StringBuffer(result);
        String reversed = sb.reverse().toString();

        result.append(oddStr);
        result.append(reversed);

        System.out.println(result);

    }
}
