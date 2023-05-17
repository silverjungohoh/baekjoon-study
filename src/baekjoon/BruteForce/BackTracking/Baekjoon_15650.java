package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1부터 n까지 자연수 중 m개를 고른 수열 (중복 불가)
 * 고른 수열은 오름차순 → 현재 뽑은 원소의 이전 값들은 고려하지 않음
 */

public class Baekjoon_15650 {

    static int n, m;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m + 1];
        visited = new boolean[n + 1];

        recursive(1, 1);
        System.out.println(sb);
    }

    static void recursive(int start, int idx) {
        if (idx == m + 1) {

            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');

        } else {

            for (int i = start; i <= n; i++) {
                if (visited[i]) continue;

                selected[idx] = i;
                visited[i] = true;

                recursive(i + 1, idx + 1);

                selected[idx] = 0;
                visited[i] = false;
            }
        }
    }
}
