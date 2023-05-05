package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 순서 o , 중복 x
 */

public class Baekjoon_2992 {

    static String x;
    static int[] selected; // 사용 여부를 확인할 배열
    static boolean[] visited; // x의 길이만큼 고른 수열울 담을 배열
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = br.readLine();
        selected = new int[x.length()];
        visited = new boolean[x.length()];
        recursive(0);
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

    static void recursive(int k) {
        if (k == x.length()) { // 종료 조건 → x의 길이만큼 수를 다 골랐을 때
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += Math.pow(10, x.length() - i - 1) * selected[i]; // ex) {1, 6, 5}를 165로 변환
            }
            if (sum > Integer.parseInt(x)) { // x를 숫자로 변환한 값보다 크지만
                ans = Math.min(sum, ans); // 그 중 제일 작은 수가 정답
            }
        } else {
            for (int i = 0; i < x.length(); i++) {
                if (visited[i]) continue;

                selected[k] = x.charAt(i) - '0';
                visited[i] = true;

                recursive(k + 1);
                // 재귀 호출 끝난 후 돌아와서
                selected[k] = 0;
                visited[i] = false;
            }
        }
    }
}
