package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/** [페어프로그래밍] 김현선(N), 홍희표(D)
 * 신입 사원
 * https://www.acmicpc.net/problem/1946
 */
public class Q1946 {
    public static void main(String[] args) throws IOException {
        solution();
        solution01();
    }

    //페어프로그래밍
    public static void solution() {

    }

    /**
     * 개인적으로 푼 것
     * 메모리 305720 KB
     * 시간 3160 ms
     */
    public static void solution01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arrays = new int[N][2];

            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arrays[j][0] = Integer.parseInt(st.nextToken());
                arrays[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrays, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];   //서류 기준 정렬(주어진 값은 '점수'가 아니라 '순위'임)
                }
            });

            int answer = 0;
            int ranking = Integer.MAX_VALUE;
            for(int j = 0; j < N; j++) {
                //arrays[j][0] 서류 기준으로 asc 정렬했기 때문에 arrays[j][1] 인터뷰 기준으로 비교
                if(ranking > arrays[j][1]) {
                    ranking = arrays[j][1];
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
