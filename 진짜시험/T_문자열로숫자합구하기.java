package 진짜시험;

public class T_문자열로숫자합구하기 {

    public static void main(String[] args) {

//        solution("1234", "56"); //1290
//        solution("56", "1234"); //1290
//        solution("1234", "5678"); //6912
//        solution("1111", "8889"); //10000
        solution("9999", "0"); //9999
    }

    public static void solution(String a, String b) {

        StringBuilder answer = new StringBuilder();

        boolean flag = a.length() > b.length();
        int lenMin = Math.min(a.length(), b.length());
        int lenMax = Math.max(a.length(), b.length());
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;

        int n = 0;

        for (int i = 0; i < lenMin; i++) {
            n += (a.charAt(lenA) - '0') + (b.charAt(lenB) - '0');
            answer.insert(0, (n % 10));
            n /= 10;

            lenA--;
            lenB--;
        }

        if (lenA != lenB) {
            String str = flag ? a : b;
            for (int i = lenMin + 1; i <= lenMax; i++) {
                n += str.charAt(lenMax - i) - '0';
                answer.insert(0, (n % 10));
                n /= 10;
            }
        }

        if (n != 0) {
            answer.insert(0, n);
        }

        System.out.println(answer);
    }
}
