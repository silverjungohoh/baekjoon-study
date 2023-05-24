package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 서로 다른 여섯 자리의 수들의 개수
 * 이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 됨 > 중복 허용 (방문 체크 X)
 */

public class Baekjoon_2210 {

    static int[][] grid = new int[5][5];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Set<Integer> set = new HashSet<>();
    static int[] arr = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0);
                Arrays.fill(arr, 0);
            }
        }
        System.out.println(set.size());
    }

    public static void dfs(int x, int y, int depth) {

        if (depth == 6) {
            int num = 0;
            for (int i = 0; i < 6; i++) {
                num += Math.pow(10, 5 - i) * arr[i];
            }
            set.add(num);
            return;
        }

        arr[depth] = grid[x][y];

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && xx < 5 && yy >= 0 && yy < 5) {
                dfs(xx, yy, depth + 1);
            }
        }
    }
}
