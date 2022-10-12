package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_DFS_2668_숫자고르기 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] nums = new int[n+1];
//
//        for (int i = 1; i <= n; i++) {
//            nums[i] = Integer.parseInt(br.readLine());
//        }
//
//        solution(nums);


        solution(new int[]{0, 3, 1, 1, 5, 5, 4, 6}); // 3 1 3 5
        solution(new int[]{0, 4, 3, 2, 1}); // 4 1 2 3 4
    }


    public static void solution(int[] nums) {
        List<Numbers> answers = new ArrayList<>();
        Set<Integer> answer = new HashSet<>();

        for (int i = 1; i < nums.length; i++) {
            Numbers numbers = new Numbers();
            answers.add(numbers);
            dfs(nums, numbers, i);
        }

        for (Numbers numbers : answers) {
            Set<Integer> index = numbers.index;
            Set<Integer> value = numbers.value;
            if (index.containsAll(value) && value.containsAll(index)) {
                answer.addAll(index);
            }
        }

        List<Integer> answerList = new ArrayList(answer);
        Collections.sort(answerList);

        System.out.println(answerList.size());
        for (int n : answerList) {
            System.out.println(n);
        }
    }

    private static void dfs(int[] nums, Numbers numbers, int current) {
        Set<Integer> index = numbers.index;
        Set<Integer> value = numbers.value;

        int next = nums[current];

        index.add(current);
        value.add(next);

        if (index.contains(next)) {
            return;
        }

        dfs(nums, numbers, next);
    }

    static class Numbers {
        Set<Integer> index, value;

        Numbers() {
            index = new HashSet<>();
            value = new HashSet<>();
        }
    }
}
