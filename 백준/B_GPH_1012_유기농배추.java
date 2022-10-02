package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_GPH_1012_유기농배추 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        boolean [][][] baechu = new boolean[tc][][];
        int[] m = new int[tc];
        int[] n = new int[tc];
        int[] k = new int[tc];
        for (int i=0; i<tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m[i] = Integer.parseInt(st.nextToken());
            n[i] = Integer.parseInt(st.nextToken());
            k[i] = Integer.parseInt(st.nextToken());
            baechu[i] = new boolean[n[i]][m[i]];
            for (int j=0; j<k[i]; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st2.nextToken());
                int row = Integer.parseInt(st2.nextToken());
                baechu[i][row][col] = true;
            }
        }
        solution(tc, m, n, k, baechu);
    }

    private static boolean dfs(int m, int n, boolean[][] baechu) {
        if (n < 0 || m < 0 || n >= baechu.length || m >= baechu[n].length) return false;
        if (!baechu[n][m]) return false;

        baechu[n][m] = false;

        dfs(m+1, n, baechu);
        dfs(m, n+1, baechu);
        dfs(m-1, n, baechu);
        dfs(m, n-1, baechu);

        return true;
    }

    private static void solution(int TC, int[] M, int[] N, int[] K, boolean[][][] BAECHU) {
        int[] answer = new int[TC];

        for (int tc=0; tc<TC; tc++) {
            for (int n=0; n<N[tc]; n++) {
                for (int m=0; m<M[tc]; m++) {
                    if (dfs(m, n, BAECHU[tc])) {
                        answer[tc]++;
                    }
                }
            }
        }

        for (int tc=0; tc<TC; tc++) {
            System.out.println(answer[tc]);
        }
    }
}
