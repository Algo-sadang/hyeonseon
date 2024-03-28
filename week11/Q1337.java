package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 올바른 배열
 * https://www.acmicpc.net/problem/1337
 */
public class Q1337 {
    /**
     * 메모리 14152 KB
     * 시간 128 ms
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;

        //'5 - cnt = 부족한 원소 개수' 를 찾아내는 방식으로 접근
        for(int i = 0; i < arr.length; i++) {
            int cnt = 0;
            int[] tempArr = new int[5];

            for(int j = 0; j < 5; j ++) {   //현재 원소 기준으로 연속된 수 배열 생성
                tempArr[j] = arr[i] + j;
            }

            int k = i;
            for(int j = 0; j < tempArr.length; j++) {
                //원장 배열에서 없는 원소를 찾아 배열을 늘리는 원리가 아니기 때문에 k는 원장 배열보다 커지면 안된다
                //i를 저장해뒀던 k로 연속된 배열이 몇개가 일치하는지 체크
                if(k < arr.length && tempArr[j] == arr[k]) {
                    cnt++;
                    k++;
                }
            }

            answer = Math.min(answer, (5 - cnt));
        }

        System.out.println(answer);
    }
}
