package baekjoon.StackQueue.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_17952 {

    static int n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Stack<Homework> stack = new Stack<>();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int check = Integer.parseInt(st.nextToken());
            if (check == 1) { // 과제가 추가된 경우
                int a = Integer.parseInt(st.nextToken()); // 과제의 만점 점수
                int t = Integer.parseInt(st.nextToken()) - 1; // 과제에 걸리는 시간 (받자마자 시작하므로 -1)
                if (t == 0) { // 과제를 완료한 경우
                    ans += a; // 과제 점수 만점 획득
                } else {
                    stack.push(new Homework(a, t));
                }
            } else { // 과제가 주어지지 않은 경우 → stack 맨 위에 있는 과제 수행
                if (!stack.isEmpty()) {
                    Homework tmp = stack.pop();
                    if (tmp.time - 1 == 0) { // 과제를 완료한 경우
                        ans += tmp.score; // 과제 점수 만점 획득
                    } else {
                        stack.push(new Homework(tmp.score, tmp.time - 1));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

class Homework {
    int score;
    int time;

    public Homework(int score, int time) {
        this.score = score;
        this.time = time;
    }
}