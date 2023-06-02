package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 첫 번째와 마지막 에너지 구슬은 고를 수 없음
 * (n - 2)개의 구슬을 선택
 */

public class Baekjoon_16198 {

    static int n, sum, max;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        recursive(0);
        System.out.println(max);
    }

    public static void recursive(int idx) {
        if (idx == n - 2) {
            max = Math.max(sum, max);
        } else {

            for (int i = 1; i < list.size() - 1; i++) {
                int l = list.get(i - 1);
                int r = list.get(i + 1);
                int tmp = list.remove(i);
                sum += l * r;

                recursive(idx + 1);

                list.add(i, tmp);
                sum -= l * r;
            }
        }
    }
}
