package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_GPH_2644_촌수계산 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        int[] question = new int[2];
//        for (int i=0; i<2; i++) {
//            question[i] = Integer.parseInt(st1.nextToken());
//        }
//        int m = Integer.parseInt(br.readLine());
//        int[][] relationship = new int[m][2];
//        for (int i=0; i<m; i++) {
//            StringTokenizer st2 = new StringTokenizer(br.readLine());
//            for (int j=0; j<2; j++) {
//                relationship[i][j] = Integer.parseInt(st2.nextToken());
//            }
//        }
//        solution(n, question, m, relationship);

        solution(9, new int[]{7, 3}, 7, new int[][]{{1,2}, {1,3}, {2,7}, {2,8}, {2,9}, {4,5}, {4,6}}); // 3
        solution(9, new int[]{8, 6}, 7, new int[][]{{1,2}, {1,3}, {2,7}, {2,8}, {2,9}, {4,5}, {4,6}}); // -1
        solution(9, new int[]{2, 3}, 7, new int[][]{{1,2}, {1,3}, {2,7}, {2,8}, {2,9}, {4,5}, {4,6}}); // 2
        solution(11, new int[]{7, 10}, 9, new int[][]{{1,2}, {1,3}, {2,7}, {2,8}, {2,9}, {4,5}, {4,6}, {7,10}, {7,11}}); // 1
    }

    private static void solution(int n, int[] question, int m, int[][] relationship) {
        int[] parent = new int[n+1];
        int answer = 0, i;

        for (i=0; i<m; i++) {
            parent[relationship[i][1]] = relationship[i][0];
        }

        int cntX = 0, cntY = 0;
        for (i = question[0]; parent[i] != 0; i = parent[i]) {
            cntX++;
        }
        for (i = question[1]; parent[i] != 0; i = parent[i]) {
            cntY++;
        }

        int younger = cntX > cntY ? question[0] : question[1];
        if (cntX != cntY) {
            for (i = 1, younger = parent[younger]; i < Math.abs(cntX - cntY); i++) {
                younger = parent[younger];
            }
        }

        int rootX = cntX > cntY ? younger : question[0];
        int rootY = cntX <= cntY ? younger : question[1];
        for (i = 0; i <= Math.min(cntX, cntY); i++) {
            if (rootX == rootY) {
                break;
            }
            rootX = parent[rootX];
            rootY = parent[rootY];
            answer++;
        }

        if (i > Math.min(cntX, cntY)) {
            answer = -1;
        } else {
            answer = answer * 2 + Math.abs(cntX - cntY);
        }

        System.out.println(answer);
    }
}
