package baekjoon.StackQueue.Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 뿅망치에 맞은 사람의 키는 (기존 키 / 2)가 됨 > 키가 1인 경우는 영향 없음
 * 모든 거인이 센티의 키보다 작도록 할 수 있는지
 */

public class Baekjoon_19638 {

    static int n, h, t, cnt;
    static int[] giants;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        giants = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 키가 큰 순서대로

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            pq.offer(height);
        }

        for (int i = 0; i < t; i++) {
            int height = pq.peek();

            if (height < h || height == 1) { // 더 이상 뿅망치를 사용할 필요 없음
                break;
            }
            pq.offer(pq.poll() / 2);
            cnt++;
        }

        if (pq.peek() < h) {
            sb.append("YES").append('\n').append(cnt);
        } else { // 뿅망치 사용 횟수를 다 써도 여전히 센티보다 키가 큰 거인이 있다면
            sb.append("NO").append('\n').append(pq.peek());
        }

        System.out.println(sb);
    }
}
