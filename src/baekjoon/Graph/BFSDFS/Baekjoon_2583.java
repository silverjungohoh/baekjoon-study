package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 몇 개의 분리된 영역으로 나누어지는지, 분리된 각 영역의 넓이
 */

public class Baekjoon_2583 {

    static int m, n, k, cnt, cur;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            for (int j = y1; j <= y2; j++) {
                for (int h = x1; h <= x2; h++) {
                    grid[j][h] = 10001;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j)) {
                    ++cnt;
                    dfs(i, j);
                    result.add(cur);
                    cur = 0;
                }
            }
        }

        sb.append(cnt).append('\n');

        Collections.sort(result);
        for (int i : result) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        ++cur;

        for (int i = 0; i < 4; i++) {
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
        if (visited[x][y] || grid[x][y] == 10001) {
            return false;
        }
        return true;
    }
}
