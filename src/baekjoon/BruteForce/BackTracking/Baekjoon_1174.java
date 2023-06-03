package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 음이 아닌 정수를 십진법으로 표기
 * 왼쪽에서부터 자리수가 감소할 때, 그 수를 줄어드는 수
 * 줄어드는 수의 최대 : 9876543210
 * 1자리 숫자 ~ 10자리 숫자 모두 탐색
 */

public class Baekjoon_1174 {

    static int n, cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 10; i++) {
            visited = new boolean[10];
            recursive(0, 0, i);
        }
        if (cnt < n) {
            System.out.println(-1);
        }
    }

    public static void recursive(int idx, long num, int k) {
        if (idx == k) {
            cnt++;
            if (cnt == n) {
                System.out.println(num);
            }
        } else {
            long before = idx > 0 ? num % 10 : -1;
            for (int i = 0; i < 10; i++) {
                if (visited[i]) continue; // 중복 X

                if (idx > 0) {
                    if (before <= i) // 이전 숫자보다 크면 X
                        continue;
                }

                visited[i] = true;
                recursive(idx + 1, num * 10 + i, k);
                visited[i] = false;
            }
        }
    }
}
