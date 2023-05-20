package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 고른 수열은 비내림차순
 * 중복되는 수열을 여러 번 출력 X
 * ex) arr = {1, 1, 3, 7} > 1이 2개라서 {1, 3} / {1, 7}이 2번씩 나옴
 */

public class Baekjoon_15664 {

    static int n, m;
    static int[] arr, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        selected = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recursive(0, 0);
        System.out.println(sb);
    }

    public static void recursive(int idx, int start) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int before = 0;
            for (int i = start; i < n; i++) {
                if (visited[i] || arr[i] == before) continue;

                selected[idx] = arr[i];
                visited[i] = true;
                before = arr[i];

                recursive(idx + 1, i + 1);

                selected[idx] = 0;
                visited[i] = false;
            }
        }
    }
}
