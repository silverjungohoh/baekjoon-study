package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15654 {

    static int n, m;
    static int[] selected, arr; // m개를 고른 수열울 담을 배열, n개의 자연수를 담을 배열
    static boolean[] visited; // 중복 여부를 확인할 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m + 1];
        arr = new int[n];
        visited = new boolean[10001];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순 정렬
        recursive(1);
        System.out.println(sb.toString());
    }

    static void recursive(int k) {
        if (k == m + 1) { // 종료 조건 → m개를 다 골랐을 때
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append("\n");
        } else {
            for (int t = 0; t < n; t++) {
                if (visited[arr[t]])
                    continue;
                selected[k] = arr[t]; // 중복되지 않는 경우 수열에 추가
                visited[arr[t]] = true; // 수열에 추가한 숫자는 방문 체크

                recursive(k + 1); // 재귀 호출
                // 재귀 호출 끝난 후 돌아와서
                visited[arr[t]] = false;
                selected[k] = 0;
            }
        }
    }
}