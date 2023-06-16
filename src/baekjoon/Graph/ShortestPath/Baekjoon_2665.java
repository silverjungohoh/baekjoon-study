package baekjoon.Graph.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon_2665 {

    static int n, ans;
    static int[][] room;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        room = new int[n][n];
        visited = new boolean[n][n];

        String str;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < n; j++) {
                room[i][j] = str.charAt(j) - '0';
            }
        }
        dijkstra(0, 0);
        System.out.println(ans);
    }

    public static void dijkstra(int x, int y) {
        PriorityQueue<Room> pq = new PriorityQueue<>();
        pq.offer(new Room(x, y, 0));

        while (!pq.isEmpty()) {
            Room now = pq.poll();

            if (visited[now.x][now.y]) continue;
            visited[now.x][now.y] = true;

            if (now.x == n - 1 && now.y == n - 1) {
                ans = now.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int xx = dx[i] + now.x;
                int yy = dy[i] + now.y;

                if (check(xx, yy) && !visited[xx][yy]) {
                    if (room[xx][yy] == 0) {
                        pq.offer(new Room(xx, yy, now.cnt + 1));
                    } else {
                        pq.offer(new Room(xx, yy, now.cnt));
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}

class Room implements Comparable<Room> {
    int x;
    int y;
    int cnt;

    public Room(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Room o) {
        return this.cnt - o.cnt;
    }
}