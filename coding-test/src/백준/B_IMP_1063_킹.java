package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_IMP_1063_킹 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String dol = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        String[] dir = new String[n];
        for (int i=0; i<n; i++) {
            dir[i] = br.readLine();
        }
        solution(king, dol, n, dir);

//        solution("A1", "A2", 5, new String[]{"B", "L", "LB", "RB", "LT"}); // A1 A2
//        solution("A1", "H8", 1, new String[]{"T"}); // A2 H8
//        solution("A1", "A2", 1, new String[]{"T"}); // A2 A3
//        solution("A1", "A2", 2, new String[]{"T", "R"}); // B2 A3
//        solution("A8", "B7", 18, new String[]{"RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB", "RB"}); // G2 H1
//        solution("C1", "B1", 3, new String[]{"L", "T", "LB"}); // B2 A1
    }

    private static boolean isExceed(char[] arr, int size) {
        return arr[0] < 'A' || arr[0] >= 'A' + size || arr[1] < '1' || arr[1] >= '1' + size;
    }

    public static void solution(String k, String d, int n, String[] dir) {

        final int SIZE = 8;
        char[] king = new char[2];
        char[] dol = new char[2];
        char[] newKing = new char[2];
        char[] newDol = new char[2];

        for (int i=0; i<2; i++) {
            king[i] = k.charAt(i);
            dol[i] = d.charAt(i);
        }

        for (int i=0; i<n; i++) {
            int col = 0;
            int row = 0;

            switch (dir[i]) {
                case "R": col++; break;
                case "L": col--; break;
                case "B": row--; break;
                case "T": row++; break;
                case "RT": col++; row++; break;
                case "LT": col--; row++; break;
                case "RB": col++; row--; break;
                case "LB": col--; row--; break;
            }

            newKing[0] = (char) (king[0] + col);
            newKing[1] = (char) (king[1] + row);
            if (isExceed(newKing, SIZE)) {
                continue;
            }

            if (newKing[0] == dol[0] && newKing[1] == dol[1]) {
                newDol[0] = (char) (dol[0] + col);
                newDol[1] = (char) (dol[1] + row);
                if (isExceed(newDol, SIZE)) {
                    continue;
                }
                dol[0] = newDol[0];
                dol[1] = newDol[1];
            }
            king[0] = newKing[0];
            king[1] = newKing[1];
        }

        System.out.println(king[0] + "" + king[1]);
        System.out.println(dol[0] + "" + dol[1]);
    }
}
