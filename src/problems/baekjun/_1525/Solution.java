package problems.baekjun._1525;

import java.io.*;
import java.util.*;

public class Solution {

    public class CustomPair {
        private int[] arr;
        private int count;

        public CustomPair(int[] arr, int count) {
            this.arr = arr;
            this.count = count;
        }

        public int[] getArr() {
            return arr;
        }

        public int getCount() {
            return count;
        }
    }


    private int[] convertTo1dArr(int[][] arr) {
        int[] ret = new int[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ret[3 * i + j] = arr[i][j];
            }
        }
        return ret;
    }

    private int[][] convertTo2dArr(int[] arr) {
        int[][] ret = new int[3][3];
        for (int i = 0; i < 9; i++) {
            int j = i / 3;
            int k = i % 3;
            ret[j][k] = arr[i];
        }

        return ret;
    }

    private boolean checkValid(int[] arr) {
        boolean ret = true;
        for (int i = 1; i < 10; i++) {
            if (i < 9 && arr[i-1] != i) {
                ret = false;
                break;
            } else if (i == 9 && arr[i - 1] != 0) {
                ret = false;
            }
        }
        return ret;
    }

    private int solution(int[][] arr) {
        int ret = Integer.MAX_VALUE;
        Queue<CustomPair> q = new ArrayDeque<>();
        int[] to1dArr = convertTo1dArr(arr);
        q.offer(new CustomPair(to1dArr, 0));
        Set<String> visit = new HashSet<>();
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            CustomPair first = q.poll();
            if (visit.contains(Arrays.toString(first.getArr()))) continue;
            visit.add(Arrays.toString(first.getArr()));
            if (checkValid(first.getArr())) {
                ret = Math.min(ret, first.getCount());
            }
            int[][] to2dArr = convertTo2dArr(first.getArr());
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (to2dArr[i][j] == 0) {
                        for (int d = 0; d < 4; d++) {
                            int ni = i + di[d];
                            int nj = j + dj[d];
                            if (ni < 3 && ni >= 0 && nj < 3 && nj >= 0) {
                                int tmp = to2dArr[i][j];
                                to2dArr[i][j] = to2dArr[ni][nj];
                                to2dArr[ni][nj] = tmp;
                                q.offer(new CustomPair(convertTo1dArr(to2dArr), first.getCount() + 1));
                                to2dArr[ni][nj] = to2dArr[i][j];
                                to2dArr[i][j] = tmp;
                            }
                        }
                    }
                }
            }
        }
        if (ret == Integer.MAX_VALUE) {
            ret = -1;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            String[] s = br.readLine().split(" ");
            int[] subarr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            arr[i] = subarr;
        }
        Solution solution = new Solution();
        bw.write(String.valueOf(solution.solution(arr)));
        bw.flush();
        bw.close();
    }
}
