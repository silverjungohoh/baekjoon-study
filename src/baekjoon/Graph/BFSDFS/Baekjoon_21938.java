package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 세 가지 색상을 평균내어 경계값 T보다 크거나 같으면 픽셀의 값을 255로, 작으면 0으로 설정
 * 화면에 물체가 총 몇 개 있는지
 */

public class Baekjoon_21938 {

    static int n, m, t, ans;
    static int[][] tmp, grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];
        tmp = new int[n][m * 3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m * 3; j++) {
                tmp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int h = 0; h < 3; h++) {
                    sum += tmp[i][j * 3 + h];
                }
                if (t <= sum / (double) 3) {
                    grid[i][j] = 255;
                } else {
                    grid[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check(i, j)) {
                    ++ans;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

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
        if (visited[x][y] || grid[x][y] != 255) {
            return false;
        }
        return true;
    }
}
