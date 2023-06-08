package baekjoon.StackQueue.Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 실행한 프로세스를 제외한 나머지 프로세스들의 우선 순위가 1 상승
 * = 실행한 프로세스의 우선 순위를 1만큼 낮추면 됨 (실행 시간이 남은 경우만)
 */

public class Baekjoon_21773 {

    static int T, n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        PriorityQueue<Element> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int pr = Integer.parseInt(st.nextToken());

            pq.add(new Element(id, time, pr));
        }

        int idx = 1;
        while (idx <= T) {
            Element tmp = pq.poll();

            if (tmp.time > 1) { // 실행 시간이 남아 있다면
                pq.add(new Element(tmp.id, tmp.time - 1, tmp.pr - 1));
            }
            idx++;
            sb.append(tmp.id).append('\n');
        }
        System.out.println(sb);
    }
}

class Element implements Comparable<Element> {
    int id;
    int time;
    int pr;

    public Element(int id, int time, int pr) {
        this.id = id;
        this.time = time;
        this.pr = pr;
    }

    @Override
    public int compareTo(Element o) {
        if (this.pr == o.pr) { // 우선 순위 값이 같으면
            return this.id - o.id; // id가 작은 순서대로
        }
        return o.pr - this.pr; // 우선 순위가 큰 순서대로
    }
}