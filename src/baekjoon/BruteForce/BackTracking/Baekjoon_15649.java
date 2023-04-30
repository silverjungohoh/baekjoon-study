package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1부터 n까지 자연수 중 m개를 고른 수열 (중복 불가)
 */

public class Baekjoon_15649 {

    static int n, m;
    static int[] selected; // m개를 고른 수열울 담을 배열
    static boolean[] visited; // 사용 여부를 확인할 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m + 1];
        visited = new boolean[n + 1];

        recursive(1);
        System.out.println(sb);
    }

    static void recursive(int k) {
        if (k == m + 1) { // 종료 조건 → m개를 다 골랐을 때
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append("\n");
        } else {
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;
                selected[k] = j; // 중복되지 않는 경우 수열에 추가
                visited[j] = true; // 수열에 추가한 숫자는 방문 체크

                recursive(k + 1);
                // 재귀 호출 끝난 후 돌아와서
                selected[k] = 0;
                visited[j] = false; // 방문 체크 해제
            }
        }
    }
}
