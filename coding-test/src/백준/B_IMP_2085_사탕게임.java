package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_IMP_2085_사탕게임 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        char[][] arr = new char[n][n];
//        for (int i=0; i<n; i++) {
//            String line = br.readLine();
//            for (int j=0; j<n; j++) {
//                arr[i][j] = line.charAt(j);
//            }
//        }
//        solution(n, arr);

        solution(3, new char[][]{{'C', 'C', 'P'}, {'C', 'C', 'P'}, {'P', 'P', 'C'}}); //3
        solution(4, new char[][]{{'P', 'P', 'P', 'P'}, {'C', 'Y', 'Z', 'Y'}, {'C', 'C', 'P', 'Y'}, {'P', 'P', 'C', 'C'}}); //4
        solution(5, new char[][]{{'Y', 'C', 'P', 'Z', 'Y'}, {'C', 'Y', 'Z', 'Z', 'P'}, {'C', 'C', 'P', 'P', 'P'}, {'Y', 'C', 'Y', 'Z', 'C'}, {'C', 'P', 'P', 'Z', 'Z'}}); //4
        solution(3, new char[][]{{'Y', 'C', 'P'}, {'C', 'Y', 'Z'}, {'C', 'C', 'P'}}); //3
    }

    private static int countCandy(char[][] arr) {
        int cnt = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(cnt, max);
            cnt = 1;
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
        }

        for (int j = 0; j < arr.length; j++) {
            max = Math.max(cnt, max);
            cnt = 1;
            for (int i = 1; i < arr[j].length; i++) {
                if (arr[i][j] == arr[i - 1][j]) {
                    cnt++;
                } else {
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
        }
        return max;
    }

    public static void solution(int n, char[][] arr) {

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == arr[i][j - 1]) continue;

                char tmp = arr[i][j - 1];
                arr[i][j - 1] = arr[i][j];
                arr[i][j] = tmp;

                max = Math.max(max, countCandy(arr));

                if (max == n) {
                    System.out.println(max);
                    return;
                }

                arr[i][j] = arr[i][j - 1];
                arr[i][j - 1] = tmp;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            for (int i = 1; i < arr[j].length; i++) {
                if (arr[i][j] == arr[i - 1][j]) continue;

                char tmp = arr[i - 1][j];
                arr[i - 1][j] = arr[i][j];
                arr[i][j] = tmp;

                max = Math.max(max, countCandy(arr));

                if (max == n) {
                    System.out.println(max);
                    return;
                }

                arr[i][j] = arr[i - 1][j];
                arr[i - 1][j] = tmp;
            }
        }

        System.out.println(max);
    }
}
