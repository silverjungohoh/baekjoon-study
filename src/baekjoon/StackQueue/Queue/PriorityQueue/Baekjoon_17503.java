package baekjoon.StackQueue.Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N일 동안 축제 진행, K 종류의 맥주를 무료로 제공
 * 참가자들은 하루에 맥주 1병만 받을 수 있음 + 이전에 받은 맥주는 다시 받을 수 없음
 * 마시는 맥주의 도수 레벨이 전씨의 간 레벨보다 높으면 맥주병이 발병
 * 마시는 맥주 N개의 선호도 합이 M이상
 */

public class Baekjoon_17503 {

    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 선호도 작은 순서대로
        PriorityQueue<Beer> select = new PriorityQueue<>((b1, b2) -> {
            if (b1.v == b2.v) { // 선호도 같으면
                return b2.c - b1.c; // 도수 작은 순서부터
            }
            return b1.v - b2.v;
        });

        // 도수 작은 순서대로
        PriorityQueue<Beer> wait = new PriorityQueue<>((b1, b2) -> {
            if (b1.c == b2.c) { // 도수 같으면
                return b2.v - b1.v; // 선호도 큰 순서부터
            }
            return b1.c - b2.c;
        });

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            wait.offer(new Beer(v, c));
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int res = -1;

        while (!wait.isEmpty()) {

            while (select.size() != n) {
                Beer b = wait.poll();
                select.offer(b);
                sum += b.v;
                max = Math.max(max, b.c);
            }

            if (sum >= m) {
                res = max;
                System.out.println(res);
                return;
            } else {
                Beer b = select.poll();
                sum -= b.v;
            }
        }
        System.out.println(res);
    }
}

class Beer {
    int v;
    int c;

    public Beer(int v, int c) {
        this.v = v;
        this.c = c;
    }
}