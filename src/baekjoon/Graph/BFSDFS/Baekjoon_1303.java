package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N명이 뭉쳐있을 때는 N^2의 위력
 */

public class Baekjoon_1303 {

    static int n, m, cnt, sum1, sum2;
    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        field = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                field[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (field[i][j] == 'W') {
                        dfs(i, j, 'W');
                        sum1 += cnt * cnt;
                    } else {
                        dfs(i, j, 'B');
                        sum2 += cnt * cnt;
                    }
                }
                cnt = 0;
            }
        }
        sb.append(sum1).append(' ').append(sum2);
        System.out.println(sb);
    }

    public static void dfs(int x, int y, char ch) {
        visited[x][y] = true;
        ++cnt;

        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if (xx >= 0 && xx < m && yy >= 0 && yy < n) {
                if (check(xx, yy, ch)) {
                    dfs(xx, yy, ch);
                }
            }
        }
    }

    public static boolean check(int x, int y, char ch) {
        if (visited[x][y] || field[x][y] != ch) {
            return false;
        }
        return true;
    }
}
