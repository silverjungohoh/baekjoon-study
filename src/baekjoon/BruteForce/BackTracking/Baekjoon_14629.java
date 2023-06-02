package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 주어진 숫자의 길이만큼 0~9 정수를 선택
 */

public class Baekjoon_14629 {

    static long n, min, ans;
    static int len;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        len = String.valueOf(n).length();
        selected = new int[len];
        visited = new boolean[10];

        if (n >= 9876543210L) {
            System.out.println("9876543210");
        } else if (n < 10) {
            System.out.println(n);
        } else {
            min = Long.MAX_VALUE;
            recursive(0, 0);
            System.out.println(ans);
        }
    }

    public static void recursive(int idx, long number) {
        if (idx == len) {
            if (min > Math.abs(number - n)) {
                min = Math.abs(number - n);
                ans = number;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                recursive(idx + 1, number * 10 + i);
                visited[i] = false;
            }
        }
    }
}
