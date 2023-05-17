package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
 * 부분수열 : 원래 수열이나 배열에서 순서는 그대로 두고 일부 원소를 제거한 수열
 */

public class Baekjoon_1182 {

    static int n, s, sum, cnt;
    static int[] arr, selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= arr.length; i++) {
            selected = new int[i]; // 배열의 길이는 1 ~ n까지 가능 (각각의 경우 모두 탐색)
            sum = 0;
            recursive(0, 0);
        }
        System.out.println(cnt);
    }

    static void recursive(int start, int idx) {
        if (idx == selected.length) { // 종료 조건 → 배열의 길이만큼 다 골랐을 때
            if (sum == s) {
                cnt++;
            }
        } else {

            for (int i = start; i < arr.length; i++) {
                if (visited[i]) continue;

                selected[idx] = arr[i];
                visited[i] = true;
                sum += arr[i];

                recursive(i + 1, idx + 1);

                visited[i] = false;
                selected[idx] = 0;
                sum -= arr[i];
            }
        }
    }
}
