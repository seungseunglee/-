package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_IMP_1713_후보추천하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] recommend = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            recommend[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, m, recommend);


//        solution(3, 9, new int[]{2, 1, 4, 3, 5, 6, 2, 7, 2}); // 2 6 7
    }

    public static void solution(int n, int m, int[] recommend) {
        Map<Integer, Candidate> candidateMap = new HashMap<>(); // studentNum: Candidate

        for (int i=0; i<m; i++) {
            int studentNum = recommend[i];

            if (!candidateMap.containsKey(studentNum)) {
                if (candidateMap.size() >= n) {
                    List<Map.Entry<Integer, Candidate>> candidateList = new ArrayList<>(candidateMap.entrySet());

                    Collections.sort(candidateList, (o1, o2) -> {
                        Candidate c1 = o1.getValue();
                        Candidate c2 = o2.getValue();
                        if (c1.vote == c2.vote) {
                            return c1.time - c2.time;
                        }
                        return c1.vote - c2.vote;
                    });

                    int removed = candidateList.get(0).getKey();
                    candidateMap.remove(removed);
                }

                candidateMap.put(studentNum, new Candidate(0, i));
            }

            Candidate candidate = candidateMap.get(studentNum);
            candidate.vote++;
        }

        List<Integer> answer = new ArrayList<>(candidateMap.keySet());
        Collections.sort(answer);

        for (int num: answer) {
            System.out.print(num + " ");
        }
    }

    static class Candidate {
        int vote, time;

        Candidate(int vote, int time) {
            this.vote = vote;
            this.time = time;
        }
    }
}
