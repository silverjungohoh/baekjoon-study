package baekjoon.StackQueue.Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_23757 {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> present = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            present.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int cnt = Integer.parseInt(st.nextToken());

            // 아이가 선물을 더 이상 가져갈 수 없는 경우 (선물 X or 원하는 것보다 적은 개수의 선물)
            if (present.isEmpty() || cnt > present.peek()) {
                System.out.println(0);
                return;
            }

            int max = present.poll();
            if (max > cnt) {
                present.add(max - cnt);
            }
        }
        System.out.println(1);
    }
}