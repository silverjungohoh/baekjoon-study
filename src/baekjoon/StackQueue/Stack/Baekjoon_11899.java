package baekjoon.StackQueue.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_11899 {

    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int cnt = 0; // 올바른 괄호열을 만들기 위해 앞과 뒤에 붙여야 할 괄호의 개수
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                cnt++; // 괄호 ')'인 경우 cnt 늘리고
                if (!stack.isEmpty()) {
                    cnt--; // 짝이 맞는 괄호가 나올 때마다 cnt 차감
                    stack.pop();
                }
            } else if (s.charAt(i) == '(') {
                stack.push('('); // 괄호 '(' 이면 스택에 push
            }
        }
        while (!stack.isEmpty()) {
            stack.pop(); // 스택에 남아 있는 괄호 '(' 개수만큼 ')' 괄호가 필요하므로
            cnt++; // 스택이 빌 때까지 cnt 증가
        }
        System.out.println(cnt);
    }
}
