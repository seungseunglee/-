package 프로그래머스;

import java.util.ArrayList;

public class P_Crane {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> basket = new ArrayList<Integer>();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    basket.add(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }

//            for (int k = basket.size() - 1; k > 0; k--) {
//                if (basket.get(k).equals(basket.get(k - 1))) {
//                    basket.remove(k);
//                    basket.remove(k - 1);
//                    k -= 2;
//                    answer += 2;
//                }
//            }
        }
// int[] basket = {4, 3, 1, 1, 3, 2, 4};
        for (int k=0; k<basket.size(); k++) {
            if (k != (basket.size()-1)) {
                if (basket.get(k) == basket.get(k+1)) {
                    basket.remove(k);
                    basket.remove(k);
                    answer++;
                    k=-1;
                }
            }
        }

        return answer;
    }
}
