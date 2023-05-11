package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 대각선으로 연결된 사각형도 걸어갈 수 있음
 */
public class Baekjoon_4963 {

    static int w, h, cnt; // 너비, 높이, 섬의 개수
    static int[][] map; // 땅과 바다 여부를 나타낸 지도
    static boolean[][] visited; // 방문 여부 확인
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            map = new int[h][w];
            visited = new boolean[h][w];
            cnt = 0;

            for (int i = 0; i < h; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (check(i, j)) {
                        ++cnt;
                        dfs(i, j);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < h && yy < w) { // 지도의 범위를 벗어나지 않아야 함
                if (check(xx, yy)) {
                    dfs(xx, yy);
                }
            }
        }
    }

    static boolean check(int x, int y) {
        if (!visited[x][y] && map[x][y] == 1) { // 사각형이 땅이고 방문한 적이 없어야 함
            return true;
        }
        return false;
    }
}
