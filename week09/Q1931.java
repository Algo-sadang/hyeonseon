package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/** [페어프로그래밍] 김현선(D), 홍희표(N)
 * 회의실 배정
 * https://www.acmicpc.net/problem/1931
 */
public class Q1931 {
    public static void main(String[] args) throws IOException {
        solution();
        solution01();
    }

    //페어프로그래밍
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arrays = new int[n][2];
        int max = 0;
        int answer = 0;

        Arrays.setAll(arrays, i -> new int[] {sc.nextInt(), sc.nextInt()});
        Arrays.sort(arrays, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        for (int i = 0; i < n; i++) {
            if (max <= arrays[i][0]) {
                max = Math.max(max, arrays[i][1]);
                answer++;
            }
        }
        System.out.println(answer);
        sc.close();
    }

    /**
     * 개인적으로 푼 것
     * 메모리 42128 KB
     * 시간 504 ms
     */
    public static void solution01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arrays = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrays[i][0] = Integer.parseInt(st.nextToken());
            arrays[i][1] = Integer.parseInt(st.nextToken());
        }

        /** lamda로 변경해도 되는 이유
         * public static <T> void sort(T[] a, Comparator<? super T> c) {...}
         *
         * 두번째 인자가 Comparator 의 구현체를 받고 있기 때문에
         * 두번째 인자로 원하는 정렬 방식을 넘겨주면 된다.

        Arrays.sort(arrays, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
         */
        Arrays.sort(arrays, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    /**
                     * startTime 이 더 작은 것 기준으로 정렬
                     * 그래야 answer를 구할 때 startTime이 더 빠른 걸 선택할 수 있음
                     * (사실 로직상 별 차이는 없지 않나.. 싶지만 이 조건이 빠지면 70~80& 대에서 틀림)
                     */
                    return o1[0] - o2[0];
                }
                //endTime 으로 비교
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int endTime = 0;
        for(int i = 0; i < N; i++) {
            int s = arrays[i][0];
            int e = arrays[i][1];

            if(endTime <= s) {
                endTime = e;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
