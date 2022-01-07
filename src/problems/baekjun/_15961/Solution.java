package problems.baekjun._15961;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");
        int N = Integer.valueOf(info[0]);
        int d = Integer.valueOf(info[1]);
        int k = Integer.valueOf(info[2]);
        int c = Integer.valueOf(info[3]);
        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.valueOf(br.readLine());
        }
        int[] selectedSushi = new int[d+1]; // index : 초밥 종류, element : k개 안에 포함된 갯수
        Deque<Integer> consecutiveK = new ArrayDeque<>(); // 연속된 k 개의 초밥을 담는 컬렉션
        int count = 0; // k개 내에 종류 수
        int ret = 0; // 결과값

        for (int i = 0; i < N+k-1; i++) {
            consecutiveK.add(sushi[i % N]);
            selectedSushi[sushi[i % N]] += 1;
            if (selectedSushi[sushi[i%N]] == 1) {
                count += 1;
            }
            if (i < k - 1) continue;

            if (selectedSushi[c] == 0) {
                ret = Math.max(ret, count + 1);
            } else {
                ret = Math.max(ret, count);
            }
            if (selectedSushi[sushi[i % N]] == 0) {
                count += 1;
            }
            int first = consecutiveK.removeFirst();
            selectedSushi[first] -= 1;
            if (selectedSushi[first] == 0) {
                count -= 1;
            }

        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
