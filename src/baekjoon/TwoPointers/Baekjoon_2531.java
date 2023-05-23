package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공 (+ 초밥 하나를 추가로 무료로 제공)
 * 슬라이딩 윈도우
 */

public class Baekjoon_2531 {

    static int n, d, k, c, ans;
    static int[] sushi; //회전하는 벨트 위 초밥 종류
    static HashMap<Integer, Integer> map = new HashMap<>(); // key : 초밥 종류, value : 초밥 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[n];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        // 처음 k개의 초밥
        for (int i = 0; i < k; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }
        // 쿠폰으로 받을 초밥 종류가 이미 존재하면 그대로, 없으면 추가
        ans = map.containsKey(c) ? map.size() : map.size() + 1;

        for (int i = 0; i < n - 1; i++) {
            if (map.get(sushi[i]) == 1) {
                map.remove(sushi[i]);
            } else {
                map.put(sushi[i], map.get(sushi[i]) - 1);
            }
            int tmp = (i + k) % n; // 원형으로 연결되어 있음
            map.put(sushi[tmp], map.getOrDefault(sushi[tmp], 0) + 1);

            if (map.containsKey(c)) {
                ans = Math.max(ans, map.size());
            } else {
                ans = Math.max(ans, map.size() + 1);
            }
        }
        System.out.println(ans);
    }
}
