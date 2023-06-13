package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 신기한 소수 찾기 > 소수 판별
 * 0~9가 아닌 1~9만 탐색 (맨 앞자리에 0이 들어올 수 없음 + 나머지 자리에 0이 오는 순간 신기한 소수가 될 수 없음)
 */

public class Baekjoon_2023 {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        recursive(0, 0);
        System.out.println(sb);
    }

    public static void recursive(int idx, int num) {
        if (idx == n) {
            sb.append(num).append('\n');
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isPrime(num * 10 + i)) {
                    recursive(idx + 1, num * 10 + i);
                }
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
