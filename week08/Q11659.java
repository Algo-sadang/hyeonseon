package week08;

import java.util.Arrays;
import java.util.Scanner;

/** [페어프로그래밍] 김현선(N), 장진홍(D)
 * 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */
public class Q11659 {
    /**
     * 메모리 260252 KB
     * 시간 2096 ms
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num = new int[n];
        int[] sum = new int[n+1];
        int[] re = new int[m];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        sum[0] = 0;
        for(int i=1; i<=n; i++) {
            sum[i] = sum[i-1] + num[i-1];
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int s = a == 1 ? 0 : sum[a-1];
            re[i] = sum[b] - s;
        }

        for (int i : re) {
            System.out.println(i);
        }
    }
}
