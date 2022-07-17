package 프로그래머스;

class P_Clothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n];

        for (int i=0; i<students.length; i++) {
            students[i] = 1;
        }

        for (int item: lost) {
            students[item-1]--;
        }

        for (int item: reserve) {
            students[item-1]++;
        }

        for (int i=0; i<students.length; i++) {
            if (students[i] == 0) {
                if (i-1 >= 0 && students[i-1] == 2) {
                    students[i]++;
                    students[i-1]--;
                } else if (i+1 < students.length && students[i+1] == 2) {
                    students[i]++;
                    students[i+1]--;
                }
            }
        }

        for (int student: students) {
            if (student == 1) answer++;
        }

        return answer;
    }
}