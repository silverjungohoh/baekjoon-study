package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * T로 표시된 부분은 가지 못하는 부분
 */

public class Baekjoon_1189 {

    static int r, c, k, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                if (s.charAt(j) == 'T') {
                    map[i][j] = 30;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        dfs(r - 1, 0, 1);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int depth) {
        if (x == 0 && y == c - 1) {
            if (depth == k) ans++;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if (xx >= 0 && xx < r && yy >= 0 && yy < c) {
                if (check(xx, yy)) {
                    dfs(xx, yy, depth + 1);
                    visited[xx][yy] = false;
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        if (visited[x][y] || map[x][y] != 0) {
            return false;
        }
        return true;
    }
}
