package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_7490 {

    static int test, n;
    static List<String> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            recursive(1, 1, 0, 1, "1");

            for (String s : list) {
                sb.append(s).append('\n');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void recursive(int idx, int num, int sum, int op, String str) {
        if (idx == n) {
            sum += (num * op);
            if (sum == 0) {
                list.add(str);
            }
        } else {
            // ' '인 경우
            recursive(idx + 1, num * 10 + (idx + 1), sum, op, str + " " + (idx + 1));
            // '+'인 경우
            recursive(idx + 1, idx + 1, sum + (num * op), 1, str + "+" + (idx + 1));
            // '-'인 경우
            recursive(idx + 1, idx + 1, sum + (num * op), -1, str + "-" + (idx + 1));
        }
    }
}
