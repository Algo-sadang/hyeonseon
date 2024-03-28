package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 세워라 반석 위에
 * https://www.acmicpc.net/problem/21967
 */
public class Q21967 {
    public static void main(String[] args) throws IOException {
        solution();         //개인공부
//        solution01();   //페어 프로그래밍
    }

    //실패, 시간초과
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        int start = 0;
        int end = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(start <= end) {
            if(end >= n) break;

            int s = arr[start];
            int e = arr[end];
            int tempMin = Math.min(s, e);
            int tempMax = Math.max(s, e);
            min = Math.min(min, tempMin);
            max = Math.max(max, tempMax);

            int abs = Math.abs(max - min);

            if(abs <= 2) {   //반석
                count = end - start;
                end++;
            }
            else {   //반속 연속성 깨짐
                count = 0;
                start++;
                end = start;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer + 1);
    }

    //실패
    public static void solution01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 1, count = 0, answer = 0;
        while(start < end) {
            int temp = Math.abs(arr[start] - arr[end]);
            if(temp <= 2) {
                start = arr[start] < arr[end] ? start : end;
                count++;
                end++;
            }
            else {
                start++;
                end = start + 1;
                answer = Math.max(count, answer);
            }

            if(end == arr.length) break;
        }

        System.out.println(answer);
    }
}
