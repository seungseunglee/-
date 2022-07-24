package 프로그래머스;

class P_NewId {
    public String solution(String new_id) {
        String answer = "";

        // 1단계 - 소문자
        answer = new_id.toLowerCase();
        System.out.println("1) " + answer);

        // 2단계 - (-), (_), (.) 특수문자만 남기기
        answer = answer.replace("~", "").replace("!", "").replace("@", "").replace("#", "").replace("$", "").replace("%", "").replace("^", "").replace("&", "").replace("*", "").replace("(", "").replace(")", "").replace("=", "").replace("+", "").replace("[", "").replace("{", "").replace("]", "").replace("}", "").replace(":", "").replace("?", "").replace(",", "").replace("<", "").replace(">", "").replace("/", "");
        System.out.println("2) " + answer);

        // 3단계 - 2번 이상 연속된 (.) 하나로 치환
        StringBuilder builder = new StringBuilder(answer);
        for (int i = 0; i < answer.length() - 1; i++) {
            char ch = answer.charAt(i);
            if (ch == '.' && ch == answer.charAt(i + 1)) {
                builder.deleteCharAt(i);
                answer = builder.toString();
                i--;
            }
        }
        System.out.println("3) " + answer);

        // 4단계 - (.) 가 처음이나 끝에 위치하면 제거
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            builder.deleteCharAt(0);
            answer = builder.toString();
        }
        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            builder.deleteCharAt(answer.length() - 1);
            answer = builder.toString();
        }
        System.out.println("4) " + answer);

        // 5단계 - 빈 문자열이라면 "a" 대입
        if (answer.equals("")) {
            answer += "a";
        }
        System.out.println("5) " + answer);

        // 6단계 - 길이가 16자 이상이면 제거, 마지막 위치 (.) 제거
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }

        builder = new StringBuilder(answer);
        if (answer.charAt(answer.length() - 1) == '.') {
            builder.deleteCharAt(answer.length() - 1);
            answer = builder.toString();
        }
        System.out.println("6) " + answer);

        // 7단계 - 길이가 2자 이하면 마지막 문자 길이 3까지 반복
        if (answer.length() <= 2) {
            char ch = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer += ch;
            }
        }
        System.out.println("7) " + answer);

        return answer;
    }
}