package baekjoon.StackQueue.Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_28107 {

    static int n, m;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = new int[n + 1];

        PriorityQueue<Customer> order = new PriorityQueue<>(); // 각 손님이 주문한 초밥 종류

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                order.add(new Customer(i, Integer.parseInt(st.nextToken())));
            }
        }

        // 요리사가 제공할 초밥 종류 (초밥 종류 오름차순 정렬)
        PriorityQueue<Integer> sushi = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sushi.add(Integer.parseInt(st.nextToken()));
        }


        while (!sushi.isEmpty()) {
            int now = sushi.poll();

            while (!order.isEmpty() && order.peek().num < now) {
                order.poll();
            }

            if (order.isEmpty()) break;

            if (order.peek().num == now) {
                ans[order.poll().idx]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb);
    }
}

class Customer implements Comparable<Customer> {
    int idx;
    int num;

    public Customer(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }

    @Override
    public int compareTo(Customer o) {
        if (this.num == o.num) {
            return this.idx - o.idx; // 동일한 초밥 종류인 경우 먼저 온 손님이 우선
        }
        return this.num - o.num; // 초밥 종류 오름차순 정렬
    }
}