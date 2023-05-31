package baekjoon.StackQueue.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택에 push 순서는 반드시 오름차순
 */

public class Baekjoon_1874 {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int before = 0;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value > before) {
                // 입력 받은 값까지 push
                for (int j = before + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                before = value; // value 다음 값부터 push 하기 위해 이전 값 저장
            }
            // 입력 받은 값이 stack 맨 위의 값과 다르다면
            else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
