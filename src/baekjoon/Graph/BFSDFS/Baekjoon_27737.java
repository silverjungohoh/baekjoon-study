package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 버섯이 자랄 수 있는 칸(0)과 없는 칸(1)
 * 버섯 포자는 버섯이 자랄 수 있는 칸에만 심을 수 있음
 * 한 칸에 여러 개의 버섯 포자를 심을 수 있음
 */

public class Baekjoon_27737 {

    static int n, m, k, cnt, total;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j)) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        for (int i : list) {
            if (i % k != 0) {
                total += i / k + 1;
            } else {
                total += i / k;
            }
        }

        if (list.size() > 0) {
            if (total > m) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println("POSSIBLE");
                System.out.println(m - total);
            }
        } else { // 버섯 포자를 심을 수 있는 곳이 없다면
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        ++cnt;

        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;

            if (xx >= 0 && xx < n && yy >= 0 && yy < n) {
                if (check(xx, yy)) {
                    dfs(xx, yy);
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        if (visited[x][y] || grid[x][y] == 1) {
            return false;
        }
        return true;
    }
}
