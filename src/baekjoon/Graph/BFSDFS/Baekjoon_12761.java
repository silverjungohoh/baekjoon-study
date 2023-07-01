package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 동규는 n에 주미는 m에 있음
 * 동규가 갈 수 있는 위치 => (+1, -1, +a, -a, +b, -b, *a, *b)
 */

public class Baekjoon_12761 {

    static int n, m, a, b;
    static int[] bridge = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int[] dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bfs(n);
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        bridge[x] = 0;
        visited[x] = true;

        while (!queue.isEmpty()) {

            int now = queue.poll();
            dx = new int[]{-1, 1, -a, a, -b, b, now * a, now * b};

            for (int i = 0; i < 8; i++) {
                int xx = (i >= 6) ? dx[i] : dx[i] + now;

                if (xx < 0 || xx > 100000) continue;
                if (visited[xx]) continue;

                queue.offer(xx);
                visited[xx] = true;
                bridge[xx] = bridge[now] + 1;

                if (xx == m) {
                    System.out.println(bridge[xx]);
                    return;
                }
            }
        }
    }
}
