package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 글자인 부분은 1, 글자가 아닌 부분은 0
 * 글자인 부분 1이 상, 하, 좌, 우, 대각선으로 인접하여 서로 연결되어 있다면 한 개의 글자
 */

public class Baekjoon_14716 {

    static int m, n, cnt;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, -1, 0, -1, 1, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        grid = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j)) {
                    ++cnt;
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if (xx >= 0 && xx < m && yy >= 0 && yy < n) {
                if (check(xx, yy)) {
                    dfs(xx, yy);
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        if (visited[x][y] || grid[x][y] != 1) {
            return false;
        }
        return true;
    }
}
