package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 대학 캠퍼스의 크기 n x m
 * 캠퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로 이동
 * 캠퍼스에서 도연이가 만날 수 있는 사람의 수
 * O는 빈 공간(0), X는 벽(1), I는 도연이, P는 사람(2)
 */

public class Baekjoon_21736 {

    static int n, m, doX, doY, cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'O') {
                    grid[i][j] = 0;
                } else if (str.charAt(j) == 'X') {
                    grid[i][j] = 1;
                } else if (str.charAt(j) == 'P') {
                    grid[i][j] = 2;
                } else {
                    doX = i;
                    doY = j;
                }
            }
        }
        bfs(doX, doY);
        System.out.println(cnt == 0 ? "TT" : cnt);
    }

    public static void bfs(int x, int y) {
        Queue<Campus> queue = new LinkedList<>();
        queue.offer(new Campus(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Campus now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (checkRange(xx, yy) && !visited[xx][yy] && grid[xx][yy] != 1) {
                    visited[xx][yy] = true;
                    queue.offer(new Campus(xx, yy));
                    if (grid[xx][yy] == 2) cnt++;
                }
            }

        }
    }

    public static boolean checkRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}

class Campus {
    int x, y;

    public Campus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}