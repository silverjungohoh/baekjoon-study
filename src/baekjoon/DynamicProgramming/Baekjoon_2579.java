package baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * (i-1)번째 칸을 밟고 i번째 칸을 밟는 경우
 * -> 연속으로 3칸을 밟을 수 없으므로 (i-2)번째 칸은 밟으면 안됨
 * (i-2)번째 칸을 밟고 i번째 칸을 밟는 경우
 */

public class Baekjoon_2579 {

    static int n;
    static int[] scores, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(preprocess());
    }

    public static int preprocess() {
        // 점화식
        // dp[i] = dp[i-3] + scores[i-1] + scores[i]
        // dp[i] = dp[i-2] + scores[i]
        if (n == 1) {
            return scores[1];
        }
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];

        for (int i = 3; i <= n; i++) {
            // 이전 계단 밟은 경우
            int yes_before = scores[i - 1] + scores[i] + dp[i - 3];

            // 이전 계단 밟지 않은 경우
            int no_before = scores[i] + dp[i - 2];
            dp[i] = Math.max(yes_before, no_before);
        }
        return dp[n];
    }
}
