package 프로그래머스;

public class P_NumericStringAndWord {
    public int solution(String s) {
        int answer = 0;
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String numsStr = "";
        String tmpStr = "";

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                numsStr += ch;
                tmpStr = "";
            } else {
                tmpStr += ch;
                for (int j=0; j<words.length; j++) {
                    String word = words[j];
                    if (tmpStr.equals(word)) {
                        numsStr += j;
                        tmpStr = "";
                        break;
                    }
                }
            }
        }
        System.out.println("numsStr:"+numsStr);
        int len = numsStr.length();
        for (int i=1; i<=numsStr.length(); i++) {
            int num = numsStr.charAt(i) - '0';
            answer += num * Math.pow(10, (len-i));
        }

        return answer;
    }
}
