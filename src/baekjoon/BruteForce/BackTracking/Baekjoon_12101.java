package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_12101 {

    static int n, k;
    static List<Integer> list = new ArrayList<>();
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            recursive(0, i, 0);
        }
        Collections.sort(ans);
        System.out.println(ans.size() >= k ? ans.get(k - 1) : -1);
    }

    public static void recursive(int sum, int m, int idx) {
        if (idx == m) {
            if (sum == n) {
                ans.add(makeStr(list));
            }
        } else {
            for (int i = 1; i <= 3; i++) {

                sum += i;
                list.add(i);

                recursive(sum, m, idx + 1);

                sum -= i;
                list.remove(list.lastIndexOf(i)); // 가장 최근에 넣은 거 삭제
            }
        }
    }

    public static String makeStr(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append('+');
            }
        }
        return sb.toString();
    }
}
