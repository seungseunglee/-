package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_IMP_1706_크로스워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[] puzzle = new String[r];

        for (int i = 0; i < r; i++) {
            puzzle[i] = br.readLine();
        }

        solution(r, c, puzzle);

//        solution(4, 5, new String[]{"adaca", "da##b", "abb#b", "abbac"}); // abb
    }

    public static void solution(int r, int c, String[] puzzle) {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String[] split = puzzle[i].split("#");
            for (String str : split) {
                if (str.length() >= 2) {
                    words.add(str);
                }
            }
        }

        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < r; j++) {
                char ch = puzzle[j].charAt(i);
                if (ch == '#') {
                    if (sb.length() >= 2) {
                        words.add(sb.toString());
                    }
                    sb = new StringBuilder("");
                } else {
                    sb.append(ch);
                }
            }
            if (sb.length() >= 2) {
                words.add(sb.toString());
            }
        }

        Collections.sort(words);

        System.out.println(words.get(0));
    }
}
