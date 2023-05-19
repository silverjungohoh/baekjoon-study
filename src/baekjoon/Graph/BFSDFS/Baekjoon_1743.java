package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1743 {

    static int n, m, k, max, cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] aisle;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        aisle = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            aisle[r - 1][c - 1] = 10001; // 해당 좌표에 쓰레기 있음
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check(i, j)) {
                    dfs(i, j);
                    max = Math.max(max, cnt);
                }
                cnt = 0;
            }
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        ++cnt;

        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;

            if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                if (check(xx, yy)) {
                    dfs(xx, yy);
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        if (visited[x][y] || aisle[x][y] != 10001) {
            return false;
        }
        return true;
    }
}
