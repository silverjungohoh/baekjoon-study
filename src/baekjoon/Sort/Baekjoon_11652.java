package baekjoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
 * 숫자 카드는 long 타입 사용
 * Map value 기준으로 정렬 
 */

public class Baekjoon_11652 {

    static int n;
    static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Long, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort(new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(entryList.get(0).getKey());
    }
    /*
     * 다른 풀이 : Map을 사용하지 않고 푸는 법
     * 숫자 카드 배열(cards)을 오름차순 정렬
     * 최빈값(mode) / 최빈값의 등장 횟수(modeCnt) / 현재 값의 등장 횟수 (curCnt)
     * 처음 : mode = cards[0] / modeCnt = 1 / curCnt = 1
     * 두 번째 카드부터 순회하면서 같은 숫자가 나오는지 or 새로운 숫자가 나오는지 확인
     */

/*
public class Baekjoon_11652 {

    static int n, modeCnt, curCnt;
    static long mode;
    static long[] cards;
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cards = new long[n];
        for(int i = 0; i<n; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(cards);

        mode = cards[0];
        modeCnt = 1;
        curCnt = 1;
        
        for(int i = 1; i<n; i++) {
            if(cards[i-1] == cards[i]) {
                curCnt++;
            } else {
                curCnt = 1;
            }
            if(curCnt > modeCnt) { // 최빈값과 최빈값 개수 갱신
                modeCnt = curCnt;
                mode = cards[i];
            }
        }
        System.out.println(mode);
    }
}
 */
}