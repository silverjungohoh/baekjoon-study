package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * x^2 - y^2 = (x + y) * (x - y)
 */

public class Baekjoon_1484 {

    static int g;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());

        long before = 1;
        long now = 1;
        boolean flag = false;

        while (now <= 100000) {
            long cal = (now + before) * (now - before);

            // 가장 인접한 제곱수 두 수의 차이가 g보다 크면 더 이상 g가 될 수 없음
            if (now - before == 1 && cal > g) break;

            if (cal == g) {
                sb.append(now).append('\n');
                flag = true;
                now++;
            } else if (cal < g) { // 현재 몸무게 늘림
                now++;
            } else { // 과거 몸무게 늘림
                before++;
            }
        }

        if (!flag) System.out.println(-1);
        System.out.println(sb);
    }
}
