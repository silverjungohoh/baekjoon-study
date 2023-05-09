package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 인접 행렬 or 인접 리스트 사용
 * dfs : 깊이 우선 탐색 (재귀 호출) / bfs : 너비 우선 탐색 (Queue 사용)
 * 방문 여부 확인하는 것이 중요 (이미 방문한 적 있다면 탐색 필요 X)
 */

public class Baekjoon_1260 {

    static int n, m, v; // 정점의 개수, 간선의 개수, 탐색 시작 정점
    static ArrayList<Integer>[] list; // 인접 리스트
    static boolean[] visited; // 정점 방문 여부 체크
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]); //  방문할 수 있는 정점들을 오름차순으로 정렬
        }
        dfs(v);
        sb.append('\n');
        Arrays.fill(visited, false); // 방문 여부 초기화
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(' ');

        for (int t : list[x]) {
            if (visited[t]) continue;
            dfs(t); // 재귀 호출
        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;
        sb.append(x).append(' ');

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int t : list[num]) {
                if (visited[t]) continue;

                queue.offer(t);
                visited[t] = true; // 방문 처리
                sb.append(t).append(' ');
            }
        }
    }
}
