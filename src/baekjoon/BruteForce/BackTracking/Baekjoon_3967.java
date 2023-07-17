package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 1부터 12까지 숫자가 헥사그램에 채워져 있는 모양
 * 숫자 네 개로 이루어진 줄의 숫자를 모두 합하면 26
 * 수를 전부 다 채워서 매직 스타를 만드는 프로그램을 작성
 * 사전 순으로 가장 앞서는 방법을 출력
 */

public class Baekjoon_3967 {

    static boolean[] visited = new boolean[13];
    static int[][] grid = new int[5][9];
    static ArrayList<Node> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                if (str.charAt(j) == 'x') {
                    list.add(new Node(i, j));
                } else if (str.charAt(j) != '.') {
                    visited[str.charAt(j) - 'A' + 1] = true;
                    grid[i][j] = str.charAt(j) - 'A' + 1;
                } else {
                    grid[i][j] = -1;
                }
            }
        }
        recursive(0);
    }

    public static void recursive(int idx) {
        if (idx == list.size()) {
            if (checkCal(grid)) {
                flag = true;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (grid[i][j] == -1) {
                            sb.append('.');
                        } else {
                            sb.append((char) (grid[i][j] - 1 + 'A'));
                        }
                    }
                    sb.append('\n');
                }
                System.out.println(sb);
                System.exit(0);
            }
        } else {

            for (int i = 1; i <= 12; i++) {
                if (visited[i]) continue;

                Node now = list.get(idx);
                grid[now.x][now.y] = i;
                visited[i] = true;

                recursive(idx + 1);

                grid[now.x][now.y] = 0;
                visited[i] = false;
            }
        }
    }

    public static boolean checkCal(int[][] grid) {
        int cal1 = grid[0][4] + grid[1][3] + grid[2][2] + grid[3][1];
        int cal2 = grid[0][4] + grid[1][5] + grid[2][6] + grid[3][7];
        int cal3 = grid[1][1] + grid[1][3] + grid[1][5] + grid[1][7];
        int cal4 = grid[1][1] + grid[2][2] + grid[3][3] + grid[4][4];
        int cal5 = grid[3][1] + grid[3][3] + grid[3][5] + grid[3][7];
        int cal6 = grid[1][7] + grid[2][6] + grid[3][5] + grid[4][4];

        return (cal1 == 26 && cal2 == 26 && cal3 == 26 && cal4 == 26 && cal5 == 26 && cal6 == 26);
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}