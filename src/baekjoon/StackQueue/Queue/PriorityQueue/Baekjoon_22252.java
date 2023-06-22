package baekjoon.StackQueue.Queue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 가치 순으로 가장 비싼 정보들을 구매
 * 한 번 거래한 정보는 파기
 * 고릴라가 가진 정보의 개수가 원하는 정보의 개수보다 적다면 모두 구매
 * 호석이가 가진 정보들의 가치 총합
 * int 범위 초과 주의
 */

public class Baekjoon_22252 {

    static int q;
    static long result;
    static Map<String, PriorityQueue<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        StringTokenizer st;
        PriorityQueue<Integer> pq;

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            if (num == 1) { // 고릴라가 정보를 획득

                if (map.containsKey(name)) { // 기존의 고릴라

                    for (int j = 0; j < cnt; j++) {
                        map.get(name).offer(Integer.parseInt(st.nextToken()));
                    }

                } else { // 새로운 고릴라

                    pq = new PriorityQueue<>(Collections.reverseOrder());
                    for (int j = 0; j < cnt; j++) {
                        pq.offer(Integer.parseInt(st.nextToken()));
                    }
                    map.put(name, pq);
                }

            } else { // 호석이가 정보를 구매

                if (map.get(name) == null || map.get(name).isEmpty()) { // 존재하지 않는 고릴라 or 고릴라가 정보 없는 경우
                    continue;
                }
                PriorityQueue<Integer> now = map.get(name);

                for (int j = 0; j < cnt; j++) {
                    if (!now.isEmpty()) {
                        result += now.poll();
                    }
                }
            }
        }
        System.out.println(result);
    }
}
