package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_MTH_1759_암호만들기 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int l = Integer.parseInt(st.nextToken());
//        int c = Integer.parseInt(st.nextToken());
//
//        char[] chars = new char[c];
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < c; i++) {
//            chars[i] = st2.nextToken().charAt(0);
//        }
//
//        solution(l, chars);


        solution(4, new char[]{'a', 't', 'c', 'i', 's', 'w'});
        // a c i s t w
        // a i / c s t w
        //acis
        //acit
        //aciw
        //acst
        //acsw
        //actw
        //aist
        //aisw
        //aitw
        //astw
        //cist
        //cisw
        //citw
        //istw
    }

    public static void solution(int l, char[] chars) {
        List<String> answer = new ArrayList<>();
        List<String> list = new ArrayList<>();

        Arrays.sort(chars);

        combination(list, chars, "", 0, l);

        for (String str : list) {
            int vowel = 0, consonant = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowel++;
                } else {
                    consonant++;
                }
            }
            if (vowel >= 1 && consonant >= 2) {
                answer.add(str);
            }
        }

        Collections.sort(answer);

        for (String str : answer) {
            System.out.println(str);
        }
    }

    static void combination(List<String> list, char[] chars, String str, int start, int r) {
        if (r == 0) {
            list.add(str);
            return;
        }

        for (int i = start; i < chars.length; i++) {
            combination(list, chars, str + chars[i], i + 1, r - 1);
        }
    }
}
