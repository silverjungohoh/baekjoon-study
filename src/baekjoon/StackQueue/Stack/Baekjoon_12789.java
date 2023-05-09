package baekjoon.StackQueue.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 현재 대기열 : FIFO → Queue 사용
 * 추가 대기열 : LIFO → Stack 사용
 */
public class Baekjoon_12789 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> now = new LinkedList<>(); // 현재 대기열
        Stack<Integer> wait = new Stack<>(); // 추가 대기열
        for (int i = 0; i < n; i++) {
            now.offer(Integer.parseInt(st.nextToken()));
        }

        int idx = 1; // 현재 간식을 받아야 할 순서
        while (!now.isEmpty()) {
            if (now.peek() == idx) {
                now.poll(); // 현재 간식을 받을 수 있는 순서와 일치하면 현재 대기열에서 삭제
                idx++;
            } else if (!wait.isEmpty() && wait.peek() == idx) {
                wait.pop(); // 현재 간식을 받을 수 있는 순서와 일치하면 추가 대기열에서 삭제
                idx++;
            } else {
                wait.add(now.poll()); // 현재 대기열에서 추가 대기열로 이동
            }
        }
        while (!wait.isEmpty()) { // 추가 대기열에 사람이 남아 있는 경우
            if (wait.peek() == idx) { // 현재 간식을 받을 수 있는 순서와 일치하면
                wait.pop(); // 추가 대기열에서 삭제
                idx++;
            } else {
                System.out.println("Sad"); // 순서대로 간식을 받을 수 없는 경우
                return;
            }
        }
        System.out.println("Nice");
    }
}
