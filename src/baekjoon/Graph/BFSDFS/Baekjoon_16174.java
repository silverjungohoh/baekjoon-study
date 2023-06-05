package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이동 가능한 방향은 오른쪽과 아래
 * 가장 오른쪽, 가장 아래 칸에 도달 시 승리
 * 한 번에 이동할 수 있는 칸의 수는, 현재 밟고 있는 칸에 쓰여 있는 수 만큼
 */

public class Baekjoon_16174 {

    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static boolean check;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        System.out.println(check ? "HaruHaru" : "Hing");
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        if (x == n - 1 && y == n - 1) {
            check = true;
            return;
        }

        for (int i = 0; i < 2; i++) {

            // grid[x][y]만큼 오른쪽으로 이동하거나 or grid[x][y]만큼 아래쪽으로 이동
            int xx = dx[i] * grid[x][y] + x;
            int yy = dy[i] * grid[x][y] + y;

            if (xx >= 0 && xx < n && yy >= 0 && yy < n) {
                if (visited[xx][yy]) continue;

                dfs(xx, yy);
            }
        }
    }
}
