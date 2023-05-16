package baekjoon.StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1 = 맨 뒤에 추가 , 2 = 맨 앞에 추가 , 3 = 가장 마지막에 추가된 문자 제거
 */
public class Baekjoon_27497 {

    static int n;
    static StringBuilder sb = new StringBuilder();
    static Deque<Element> deq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int idx = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st.nextToken());
            String s = st.hasMoreTokens() ? st.nextToken() : "";
            if (b == 1) {
                deq.offerLast(new Element(idx, s.charAt(0)));
                idx++;
            } else if (b == 2) {
                deq.offerFirst(new Element(idx, s.charAt(0)));
                idx++;
            } else {
                if (deq.isEmpty()) continue;
                // 맨 앞 or 맨 뒤 누가 먼저 들어왔는지 확인
                if (deq.peekLast().idx > deq.peekFirst().idx) {
                    deq.pollLast();
                } else {
                    deq.pollFirst();
                }
            }
        }

        if (deq.isEmpty()) {
            System.out.println(0);
            return;
        }

        while (!deq.isEmpty()) {
            sb.append(deq.poll().c);
        }

        System.out.println(sb.toString());
    }
}

class Element {
    int idx; // 들어오는 순서
    char c;

    public Element(int idx, char c) {
        this.idx = idx;
        this.c = c;
    }
}