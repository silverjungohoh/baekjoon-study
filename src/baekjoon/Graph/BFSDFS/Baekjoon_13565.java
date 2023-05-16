package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 전류는 섬유 물질의 가장 바깥쪽 흰색 격자들에 공급
 * 가장 안쪽까지 전류가 공급될 수 있는지
 * dfs 사용
 */

public class Baekjoon_13565 {

    static int m, n;
    static int[][] material;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        material = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                material[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            if (material[0][i] == 0 && check(0, i)) {
                dfs(0, i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (material[m - 1][i] == 10) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        material[x][y] = 10;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx < m && yy >= 0 && yy < n) {
                if (check(xx, yy)) {
                    dfs(xx, yy);
                }
            }
        }
    }

    static boolean check(int x, int y) {
        if (visited[x][y] || material[x][y] == 1) {
            return false;
        }
        return true;
    }
}
