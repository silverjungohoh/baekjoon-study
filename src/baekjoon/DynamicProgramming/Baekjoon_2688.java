package baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 어떤 숫자가 줄어들지 않는다
 * = 그 숫자의 각 자리 수보다 그 왼쪽 자리 수가 작거나 같은 경우
 * 숫자의 앞에 0이 있어도 ok
 */

public class Baekjoon_2688 {

    static int test, n;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(br.readLine());
        dp = new long[65][10];
        preprocess();

        for (int i = 0; i < test; i++) {
            n = Integer.parseInt(br.readLine());
            long result = 0;
            for (int j = 0; j <= 9; j++) {
                result += dp[n][j];
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    public static void preprocess() {
        // 초기값 구하기
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        // 점화식 2차원 배열에 길이가 i이고,숫자가 j로 끝나는 오르막 수의 개수를 저장
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][0] = 1;
                    continue;
                }
                // 점화식
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
    }
}
