package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠김
 * 물에 잠기지 않는 안전한 영역의 최대 개수
 * 아무 지역도 물에 잠기지 않을 수도 있음
 * 지역의 최대 높이보다 큰 경우 탐색할 필요 없음 (어처피 다 잠김)
 */

public class Baekjoon_2468 {

    static int n, max, min, cnt, ans;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int h = Integer.parseInt(st.nextToken());
                grid[i][j] = h;
                max = Math.max(max, h);
                min = Math.min(min, h);
            }
        }
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < n; j++) {
                for (int h = 0; h < n; h++) {
                    if (check(j, h, i)) {
                        ++cnt;
                        dfs(j, h, i);
                    }
                }
            }
            ans = Math.max(ans, cnt);
            cnt = 0;
            for (boolean[] t : visited) {
                Arrays.fill(t, false);
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && xx < n && yy >= 0 && yy < n) {
                if (check(xx, yy, height)) {
                    dfs(xx, yy, height);
                }
            }
        }
    }

    public static boolean check(int x, int y, int height) {
        if (visited[x][y] || grid[x][y] <= height) { // 방문 o or 물에 잠김
            return false;
        }
        return true;
    }
}
