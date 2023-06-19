package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호
 * 그 헛간까지의 거리 / 그 헛간과 같은 거리를 갖는 헛간의 개수
 */

public class Baekjoon_6118 {

    static int n, m, max, cnt, min;
    static boolean[] visited;
    static int[] result;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 양방향
            list[s].add(e);
            list[e].add(s);
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        bfs(1);

        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                cnt++;
                min = Math.min(i, min);
            }
        }
        sb.append(min).append(' ').append(max).append(' ').append(cnt);
        System.out.println(sb);
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;
        result[x] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list[now]) {
                if (visited[next]) continue;

                visited[next] = true;
                result[next] = result[now] + 1;
                max = Math.max(result[next], max);
                queue.offer(next);
            }
        }
    }
}
