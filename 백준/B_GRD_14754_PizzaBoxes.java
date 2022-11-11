package 백준;

import java.io.IOException;

public class B_GRD_14754_PizzaBoxes {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int col = Integer.parseInt(st.nextToken());
//        int row = Integer.parseInt(st.nextToken());
//
//        int[][] boxes = new int[col][row];
//
//        for (int i = 0; i < col; i++) {
//            StringTokenizer st2 = new StringTokenizer(br.readLine());
//            for (int j = 0; j < row; j++) {
//                boxes[i][j] = Integer.parseInt(st2.nextToken());
//            }
//        }
//
//        solution(col, row, boxes);


        solution(4, 4, new int[][]{ // 72
                {1, 2, 4, 6},
                {16, 9, 13, 11},
                {5, 10, 8, 15},
                {12, 14, 7, 3}});

        solution(4, 4, new int[][]{ // 54
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}});

        solution(3, 5, new int[][]{ // 101
                {1, 11, 25, 20, 23},
                {17, 2, 16, 21, 15},
                {10, 3, 12, 24, 22}});

        solution(2, 3, new int[][]{ // 1
                {0, 1, 2},
                {3, 4, 5}});
    }

    public static void solution(int col, int row, int[][] boxes) {
        long answer = 0;
        boolean[][] maxBoxes = new boolean[col][row];

        for (int i = 0; i < col; i++) {
            long maxRow = -1;
            int maxRowIndex = 0;
            for (int j = 0; j < row; j++) {
                if (maxRow < boxes[i][j]) {
                    maxRow = boxes[i][j];
                    maxRowIndex = j;
                }
            }
            maxBoxes[i][maxRowIndex] = true;
        }

        for (int j = 0; j < row; j++) {
            long maxCol = -1;
            int maxColIndex = 0;
            for (int i = 0; i < col; i++) {
                if (maxCol < boxes[i][j]) {
                    maxCol = boxes[i][j];
                    maxColIndex = i;
                }
            }
            maxBoxes[maxColIndex][j] = true;
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!maxBoxes[i][j]) {
                    answer += boxes[i][j];
                }
            }
        }

        System.out.println(answer);
    }
}
