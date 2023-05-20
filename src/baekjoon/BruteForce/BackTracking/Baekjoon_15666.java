package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 비내림차순
 * 같은 수 여러 번 고를 수 있음 > 방문 체크 필요 없음
 * 중복되는 수열을 여러 번 출력 X
 */

public class Baekjoon_15666 {

    static int[] arr, selected;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        selected = new int[m];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순 배열
        recursive(0, 0);
        System.out.println(sb);
    }

    public static void recursive(int idx, int start) {
        if (idx == m) { // 종료 조건
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int before = 0;
            for (int i = start; i < n; i++) {
                if (before == arr[i]) continue;

                selected[idx] = arr[i];
                before = arr[i];

                recursive(idx + 1, i);

                selected[idx] = 0;
            }
        }
    }
}
