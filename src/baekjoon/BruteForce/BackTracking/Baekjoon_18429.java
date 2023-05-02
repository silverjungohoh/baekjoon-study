package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 하루에 k만큼 중량이 감소 > 중량 증가량 배열 모든 값을 k만큼 빼기
 * 중량이 500 밑으로 떨어지면 안됨
 * 순서 O, 중복 X
 */

public class Baekjoon_18429 {

    static int n, k, cnt;
    static int sum = 500; // 현재 운동 중량 기본값
    static int[] weight, selected; // 중량 증가량 담는 배열, 운동 키트 적용 순서를 담을 배열
    static boolean[] visited; // 사용 여부를 확인할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        weight = new int[n+1];
        selected = new int[n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i<=n; i++) {
            weight[i] = Integer.parseInt(st.nextToken()) - k;
        }
        recursive(1);
        System.out.println(cnt);
    }
    static void recursive(int idx) {
        if(idx == n+1) { // 종료 조건
            cnt++;
        } else {
            for(int t = 1; t<=n; t++) {
                if(visited[t] || sum + weight[t] < 500) continue;
                selected[idx] = weight[t];
                visited[t] = true;
                sum += weight[t];

                recursive(idx+1);
                // 재귀 호출 끝난 후 돌아와서
                visited[t] = false;
                sum -= weight[t];
                selected[idx] = 0;
            }
        }
    }
}
