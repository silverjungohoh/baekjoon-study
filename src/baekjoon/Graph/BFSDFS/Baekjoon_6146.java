package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 키파 (0, 0) -> 신아 (x, y)
 * 웅덩이를 밟지 않으면서 신아에게 갈 수 있는 최소 거리
 */

public class Baekjoon_6146 {

    static int x, y, n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        grid = new int[1001][1001];
        visited = new boolean[1001][1001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grid[b + 500][a + 500] = Integer.MAX_VALUE; // 웅덩이 있음
        }


        bfs(500, 500);
    }

    public static void bfs(int a, int b) {
        Queue<Road> queue = new LinkedList<>();
        queue.offer(new Road(a, b, 0));

        while (!queue.isEmpty()) {

            Road now = queue.poll();

            int nowX = now.x;
            int nowY = now.y;

            if (nowX == y + 500 && nowY == x + 500) {
                System.out.println(now.dist);
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int xx = nowX + dx[i];
                int yy = nowY + dy[i];

                if (check(xx, yy)) { // 범위를 벗어나지 않아야 함
                    if (visited[xx][yy]) continue; // 방문한 적이 있는 경우
                    if (grid[xx][yy] == Integer.MAX_VALUE) continue; // 웅덩이인 경우

                    visited[xx][yy] = true;
                    queue.offer(new Road(xx, yy, now.dist + 1));
                }
            }


        }
    }

    public static boolean check(int a, int b) {
        return a >= 0 && a <= 1000 && b >= 0 && b <= 1000;
    }
}

class Road {
    int x;
    int y;
    int dist;

    public Road(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}