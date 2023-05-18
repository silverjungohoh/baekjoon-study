package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 순서 o , 중복 x
 * n개의 수를 나열하는 모든 경우의 수
 */
public class Baekjoon_10819 {

    static int n, max;
    static int[] arr, selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        selected = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        recursive(0);
        System.out.println(max);
    }

    public static void recursive(int idx) {
        if (idx == n) { // 종료 조건
            max = Math.max(cal(selected), max);
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                selected[idx] = arr[i];

                recursive(idx + 1);

                visited[i] = false;
                selected[idx] = 0;
            }
        }
    }

    public static int cal(int[] selected) {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(selected[i] - selected[i + 1]);
        }
        return sum;
    }
}
