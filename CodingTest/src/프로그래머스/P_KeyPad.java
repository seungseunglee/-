package 프로그래머스;

class P_KeyPad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        final String LEFT = "L";
        final String RIGHT = "R";
        int[] left = {3, 0}, right = {3, 2};
        int[][] keypad = {
                {0,0}, {0,1}, {0,2}, // 0 1 2   // 1 2 3
                {1,0}, {1,1}, {1,2}, // 3 4 5   // 4 5 6
                {2,0}, {2,1}, {2,2}, // 6 7 8   // 7 8 9
                {3,1}         //   9     //   0
        };

        for (int number: numbers) {
            int pushed = number - 1;
            if (pushed < 0) pushed = 9;
//            System.out.print(pushed + " ");

            switch (number) {
                case 1:
                case 4:
                case 7:
                    answer += LEFT;
                    left = keypad[pushed];
                    break;
                case 3:
                case 6:
                case 9:
                    answer += RIGHT;
                    right = keypad[pushed];
                    break;
                case 2:
                case 5:
                case 8:
                case 0:
                    int[] key = keypad[pushed]; // number: 2 -> {0,1}
                    int lDis = Math.abs(key[0] - left[0]) + Math.abs(key[1] - left[1]);
                    int rDis = Math.abs(key[0] - right[0]) + Math.abs(key[1] - right[1]);
                    System.out.println("눌린키:" + number + " 왼:" + lDis + " 오:" + rDis);
                    if (lDis > rDis) {
                        answer += RIGHT;
                    } else if (lDis < rDis) {
                        answer += LEFT;
                    } else {
                        if (hand.equals("right")) {
//                            System.out.print(" " + number + " 오른손잡이");
                            answer += RIGHT;
                        } else {
//                            System.out.print(" " + number + " 왼손잡이");
                            answer += LEFT;
                        }
                    }
                    break;
            }
        }

        return answer;
    }
}