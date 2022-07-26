package 이코테;

public class 이코테_DFSBFS_음료수얼려먹기 {

    public static void main(String[] args) {
        solution(4,5, new boolean[][]{{true,true,false,false,true},{true,true,true,false,false},{false,false,false,false,false},{true,true,true,true,true}});
    }

    private static boolean dfs(int n, int m, boolean[][] mold) {
        if (n < 0 || m < 0 || n >= mold.length || m >= mold[n].length) return false;
        if (!mold[n][m]) return false;

        mold[n][m] = false;
        dfs(n-1, m, mold);
        dfs(n, m-1, mold);
        dfs(n+1, m, mold);
        dfs(n, m+1, mold);
        return true;
    }

    private static void solution(int n, int m, boolean[][] mold) {
        int answer = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dfs(i, j, mold)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
