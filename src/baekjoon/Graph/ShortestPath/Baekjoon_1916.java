package baekjoon.Graph.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1916 {

    static int n, m, s, e;
    static boolean[] visited;
    static int[] cost;
    static List<Bus>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        cost = new int[n + 1];
        list = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(cost, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[s].add(new Bus(e, c));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dijkstra(s);
        System.out.println(cost[e]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0)); // 출발 노드
        cost[start] = 0; // 출발점에 대한 최소 비용 0

        while (!pq.isEmpty()) {
            Bus now = pq.poll();

            if (visited[now.idx]) continue;
            visited[now.idx] = true; // 꺼낸 노드는 방문 처리

            for (Bus next : list[now.idx]) {
                // 방문한 적이 없고, 현재 노드를 거쳐서 다른 노드로 이동하는 비용이 더 적은 경우
                if (!visited[next.idx] && cost[next.idx] > cost[now.idx] + next.cost) {
                    cost[next.idx] = cost[now.idx] + next.cost;

                    pq.offer(new Bus(next.idx, cost[next.idx]));
                }
            }
        }
    }
}

class Bus implements Comparable<Bus> {
    int idx;
    int cost;

    public Bus(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus o) {
        return this.cost - o.cost; // 비용이 가장 적은 순서대로
    }
}