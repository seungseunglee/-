package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_BFS_1326_폴짝폴짝 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        int[] nums = new int[n+1];
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//
//        for (int i=1; i<=n; i++) {
//            nums[i] = Integer.parseInt(st1.nextToken());
//        }
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//
//        int begin = Integer.parseInt(st2.nextToken());
//        int end = Integer.parseInt(st2.nextToken());
//
//        solution(nums, begin, end);

        solution(new int[]{1, 2, 2, 1, 2}, 1 , 5);
    }


    public static void solution(int[] nums, int begin, int end) {
        int answer = -1;

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();
            int loc = n.loc, depth = n.depth;
            int jump = nums[loc];

            if (loc == end) {
                answer = depth;
                break;
            }

            for (int i=1; loc + jump * i < nums.length; i++) {
                q.offer(new Node(loc + jump * i, depth + 1));
            }

            for (int i=1; loc - jump * i > 0; i++) {
                q.offer(new Node(loc - jump * i, depth + 1));
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int loc;
        int depth;

        Node(int loc, int depth) {
            this.loc = loc;
            this.depth = depth;
        }
    }
}
