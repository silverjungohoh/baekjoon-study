package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 인접 행렬 사용
 * 1 = 집이 있는 곳  / 0 = 집이 없는 곳
 */
public class Baekjoon_2667 {

    static int n;
    static int[][] map;
    static boolean[][] visited; // 방문 여부 확인
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int total; // 총 단지 수
    static int[] cnt; // 각 단지의 집 개수를 담을 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j) && map[i][j] == 1) {
                    ++total;
                    dfs(i, j); // 방문한 적이 없고 집이 있는 경우만 탐색 시작
                }
            }
        }

        sb.append(total).append('\n');

        cnt = new int[total]; // 배열 길이는 단지 개수로 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0)
                    cnt[map[i][j] - 1]++;
            }
        }

        Arrays.sort(cnt); // 오름차순 정렬
        for (int i = 0; i < total; i++) {
            sb.append(cnt[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        map[x][y] = total;

        // 상하좌우 이동하며 탐색
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (check(xx, yy)) {
                dfs(xx, yy);
            }
        }
    }

    static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) { // 지도의 범위를 벗어나는 경우
            return false;
        }
        if (visited[x][y] || map[x][y] == 0) { // 방문한 적 있거나 집이 없는 경우
            return false;
        }
        return true;
    }
}
