package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이코테_05_DFSBFS_미로탈출 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n][m];
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = line.charAt(j) - '0'; // 0:괴물O, 1:괴물X
            }
        }
        solution(n, m, maze);
    }

    private static void solution(int n, int m, int[][] maze) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for (int i=0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newY < 0 || newX >= n || newY >= m) {
                    continue;
                }
                if (maze[newX][newY] == 0) {
                    continue;
                }
                if (maze[newX][newY] == 1) {
                    maze[newX][newY] = maze[x][y] + 1;
                    q.offer(new Node(newX, newY));
                }
            }
        }
        System.out.println(maze[n-1][m-1]);
    }

    static class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


