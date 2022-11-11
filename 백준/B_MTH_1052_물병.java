package 백준;

import java.io.IOException;

public class B_MTH_1052_물병 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        solution(n, k);


        solution(3, 1); // 1 (2)
        solution(13, 2); // 3 (4)
        solution(1000000, 5); // 15808 (20)
        solution(3, 2); // 0 (2)
        solution(13, 3); // 0 (4)
        solution(32, 1); // 0
        solution(1, 1); // 0
    }

    public static void solution(int n, int k) { // n: 물병, k: 옮길 수 있는 물병의 수
        int answer = -1;

        int low = 0, high = 24, leftNum = 0;

        while (low <= high) {
            int mid = (high + low) / 2;
            int midNum = (int) Math.pow(2, mid);
            leftNum = midNum >> 1;

            if (leftNum < n && n <= midNum) {
                break;
            } else if (midNum < n) {
                low = mid + 1;
            } else if (midNum > n){
                high = mid - 1;
            }
        }

        int num = n;

        for (int i = 0; i < k - 1; i++) {
            num -= leftNum;

            while (leftNum > num) {
                leftNum = leftNum >> 1;
            }
        }


        int rightNum = leftNum << 1;
        if (num == leftNum || num == rightNum || num == 1) {
            answer = 0;
        } else {
            answer = rightNum - num;
        }

        System.out.println(answer);
    }

}
