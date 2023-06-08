package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 산봉우리는 같은 높이를 가지는 하나의 격자 혹은 인접한 격자들의 집합 > 인접한 지점은 총 8개
 * dfs 호출한 지점의 높이보다 높은 지점이 없다면 산봉오리
 */

public class Baekjoon_1245 {

    static int n, m, cnt;
    static int[][] farm;
    static boolean[][] visited;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, -1, 0, -1, 1, -1, 1, 0};
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        farm = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    check = true;
                    dfs(i, j);
                    if (check) cnt++;
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

            if (xx >= 0 && xx < n && yy >= 0 && yy < m) { // 농장의 범위를 벗어나지 않아야 함

                if (farm[xx][yy] > farm[x][y]) { // 인접한 곳의 높이가 더 높으면
                    check = false; // 산봉오리가 아님
                }

                if (visited[xx][yy]) continue; // 방문한 적이 있다면 pass

                // 높이가 같은 경우만 탐색 (인접한 곳의 높이를 확인하기 위해)
                if (farm[xx][yy] == farm[x][y]) {
                    dfs(xx, yy);
                }
            }
        }
    }
}
