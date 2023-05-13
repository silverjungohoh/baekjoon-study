package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * '.'은 빈 필드, 글자 '#'는 울타리, 'o'는 양, 'v'는 늑대를 의미
 */

public class Baekjoon_3184 {

    static int r, c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] yard; // 마당
    static boolean[][] visited; // 방문 여부 확인
    static int[] num; // 같은 영역 내 양과 늑대의 수를 담는 배열
    static int[] ans = new int[2]; // 마당 내 양과 늑대의 수를 담을 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        yard = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                if (s.charAt(j) == '#') { // 울타리
                    yard[i][j] = -1;
                } else if (s.charAt(j) == 'o') { // 양
                    yard[i][j] = 1;
                    ans[0]++;
                } else if (s.charAt(j) == 'v') { // 늑대
                    yard[i][j] = 2;
                    ans[1]++;
                } else { // 빈 필드
                    yard[i][j] = 0;
                }
            }
        }
        // 각 영역마다 양이 우세한지 늑대가 우세한지 계산
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && yard[i][j] != -1) {
                    num = new int[2]; // 영역마다 배열 초기화
                    dfs(i, j);
                    if (num[0] > num[1]) { // 양이 더 많으면 늑대 삭제
                        ans[1] -= num[1]; // 전체 늑대 수 - 해당 구역에서 삭제된 늑대 수
                    } else { // 양이 늑대보다 적거나 같으면 양 삭제
                        ans[0] -= num[0]; // 전체 양 수 - 해당 구역에서 삭제된 양 수
                    }
                }
            }
        }
        for (int i : ans) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        // 특정 구역에 양과 늑대가 몇 마리씩 있는지 계산
        if (yard[x][y] == 1) {
            num[0]++;
        } else if (yard[x][y] == 2) {
            num[1]++;
        }

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < r && yy < c) {
                if (check(xx, yy)) {
                    dfs(xx, yy);
                }
            }
        }
    }

    static boolean check(int x, int y) {
        if (visited[x][y] || yard[x][y] == -1) {
            return false;
        }
        return true;
    }
}
