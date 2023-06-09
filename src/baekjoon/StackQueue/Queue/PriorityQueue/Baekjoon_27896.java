package baekjoon.StackQueue.Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 가지 운동을 일으키지 않게 하기 위한 가지의 최소 개수
 */

public class Baekjoon_27896 {

    static int n, m, cnt;
    static int[] stud;
    static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        stud = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stud[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            total += stud[i];
            pq.add(stud[i]);

            if (total >= m) { // 불만도가 m 이상이 되면
                cnt++;
                int tmp = pq.poll();
                total -= tmp * 2;
            }

        }
        System.out.println(cnt);
    }
}