package baekjoon.StackQueue.Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 찬우가 받을 수 있는 최종 성적의 최댓값
 * 최종 성적의 합 = 모든 과목의 점수 합
 */

public class Baekjoon_23254 {

    static int n, m, total;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[m];
        b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            total += a[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Subject> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            pq.add(new Subject(i + 1, a[i], b[i]));
        }

        int study = 24 * n;

        while (!pq.isEmpty()) {
            int max = 0;
            Subject sb = pq.poll();

            max = (100 - sb.score) / sb.up;

            if (study - max >= 0) {
                study -= max;
            } else {
                total += sb.up * study;
                break;
            }

            int upScore = sb.up * max;
            total += upScore;

            if (upScore + sb.score < 100) { // 해당 과목의 점수가 100점보다 작으면 올릴 수 있는 점수가 더 존재
                // 시간 당 올릴 수 있는 점수 > 올리고 남은 점수로 갱신
                pq.add(new Subject(sb.idx, sb.score + upScore, (100 - sb.score) % sb.up));
            }
        }
        System.out.println(total);
    }
}

class Subject implements Comparable<Subject> {
    int idx;
    int score;
    int up;

    public Subject(int idx, int score, int up) {
        this.idx = idx;
        this.score = score;
        this.up = up;
    }

    @Override
    public int compareTo(Subject o) {
        return o.up - this.up; // 시간 당 올릴 수 있는 점수가 큰 순서대로
    }
}