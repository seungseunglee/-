package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_IMP_1713_후보추천하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int total = Integer.parseInt(br.readLine());
        int[] votes = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<total; i++) {
            votes[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, total, votes);
    }

    public static void solution(int N, int total, int[] votes) {
        List<Candidate> candidates = new ArrayList<>();

        for (int stage=0; stage<total; stage++) {
            int vote = votes[stage];
            boolean isFound = false;

            for (Candidate candidate: candidates) {
                if (candidate.n == vote) {
                    candidate.voted++;
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                continue;
            }

            if (candidates.size() >= N) {
                Collections.sort(candidates, (o1, o2) -> {
                    if (o1.voted == o2.voted) {
                        return o1.posted - o2.posted; // 오름차순
                    }
                    return o1.voted - o2.voted; // 오름차순
                });
                candidates.remove(0);
            }

            candidates.add(new Candidate(vote, stage));
        }

        Collections.sort(candidates, (o1, o2) -> o1.n - o2.n);

        for (Candidate candidate: candidates) {
            System.out.print(candidate.n + " ");
        }
    }

    static class Candidate {
        int n;
        int voted;
        int posted;

        Candidate(int n, int stage) {
            this.n = n;
            this.posted = stage;
            voted = 1;
        }
    }
}
