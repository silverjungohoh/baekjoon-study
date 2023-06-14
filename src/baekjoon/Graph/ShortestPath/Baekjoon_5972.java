package baekjoon.Graph.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 양방향
 */

public class Baekjoon_5972 {

    static int n, m;
    static ArrayList<Path>[] list;
    static boolean[] visited;
    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        costs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[s].add(new Path(e, cost));
            list[e].add(new Path(s, cost));
        }

        Arrays.fill(costs, Integer.MAX_VALUE);
        System.out.println(dijkstra(1, n));
    }

    public static int dijkstra(int x, int y) {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.offer(new Path(x, 0));
        costs[x] = 0;

        while (!pq.isEmpty()) {
            Path now = pq.poll();

            if (visited[now.idx]) continue;
            visited[now.idx] = true;

            for (Path next : list[now.idx]) {
                if (!visited[next.idx] && costs[next.idx] > costs[now.idx] + next.cost) {
                    costs[next.idx] = costs[now.idx] + next.cost;
                    pq.offer(new Path(next.idx, costs[next.idx]));
                }
            }
        }
        return costs[y];
    }
}

class Path implements Comparable<Path> {
    int idx;
    int cost;

    public Path(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Path o) {
        return this.cost - o.cost;
    }
}