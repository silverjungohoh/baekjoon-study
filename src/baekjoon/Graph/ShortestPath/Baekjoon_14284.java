package baekjoon.Graph.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * s와 t가 연결이 되는 시점의 간선의 가중치의 합이 최소가 되도록 추가하는 간선의 순서를 조정
 * s -> e까지 최단 경로
 */

public class Baekjoon_14284 {

    static int n, m, s, e;
    static List<Node>[] list;
    static boolean[] visited;
    static int[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n + 1];
        visited = new boolean[n + 1];
        weights = new int[n + 1];

        Arrays.fill(weights, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dijkstra(s);
        System.out.println(weights[e]);
    }

    public static void dijkstra(int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));
        weights[x] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.idx]) continue;
            visited[now.idx] = true;

            for (Node next : list[now.idx]) {
                if (!visited[next.idx] && weights[next.idx] > weights[now.idx] + next.weight) {
                    weights[next.idx] = weights[now.idx] + next.weight;

                    pq.offer(new Node(next.idx, weights[next.idx]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int idx;
    int weight;

    public Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}