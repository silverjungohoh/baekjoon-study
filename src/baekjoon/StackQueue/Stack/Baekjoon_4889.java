package baekjoon.StackQueue.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_4889 {

    static int idx = 1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {

            s = br.readLine();
            int cnt = 0;

            if (s.charAt(0) == '-') break;

            Stack<Character> stack = new Stack<>();
            Stack<Character> close = new Stack<>(); // 짝이 맞지 않는 닫는 괄호를 담는 스택

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '{') {
                    stack.push('{');
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        close.push('}');
                    }
                }
            }
            if (stack.size() % 2 == 0 && close.size() % 2 == 0) { // 남아 있는 여는 괄호와 닫는 괄호의 개수가 짝수인 경우
                cnt += stack.size() / 2 + close.size() / 2;
            } else if (stack.size() % 2 == 1 && close.size() % 2 == 1) { // 남아 있는 여는 괄호와 닫는 괄호의 개수가 홀수인 경우
                cnt += stack.size() / 2 + 1 + close.size() / 2 + 1;
            }

            sb.append(idx++).append(". ").append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
