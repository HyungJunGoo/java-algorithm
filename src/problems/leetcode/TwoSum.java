package problems.leetcode;

import java.util.*;

public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, List<Integer>> nums_to_idx = new HashMap<>();
            int[] ret = new int[] {-1,-1};

            for (int i = 0; i < nums.length; i++) {
                nums_to_idx.put(nums[i], nums_to_idx.getOrDefault(nums[i], new ArrayList<>(List.of(i))));
            }
            for (int i = 0; i <nums.length; i++) {
                if (!nums_to_idx.containsKey(target - nums[i])) {
                    continue;
                } else {
                    for (int j : nums_to_idx.get(target-nums[i])) {
                        if (i != j) {
                            ret[0] = i;
                            ret[1] = j;
                            break;
                        }
                    }
                    if (ret[0] != -1) {
                        break;
                    }
                }
            }

            return ret;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 7, 11, 5};
        int target1 = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums1, target1)));
    }
}
