package problems.leetcode;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSumSolution1(int[] nums) {
        // Two Pointer
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) {
            return new ArrayList<>(res);
        }
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public List<List<Integer>> threeSumSolution2(int[] nums) {
        // Hash table
        Arrays.sort(nums);
        if(nums.length < 3) return Collections.emptyList();
        if(nums[0] > 0) return Collections.emptyList();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }

//        for (Integer k: indexMap.keySet()){
//            System.out.println("k::" + k + ", v::" + indexMap.get(k));
//        }

        Set<List<Integer>> ret = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]>0) break;
            for (int j = i+1; j < nums.length - 1; j++) {
                int target = -(nums[i]+nums[j]);
                if (indexMap.containsKey(target) && indexMap.get(target) > j) {
                    ret.add(List.of(nums[i], nums[j], target));
                }
            }
        }
        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();


        int nums[] = new int[]{-1, 0, 1, 2, -1, -4};
        // -4, -1, -1, 0, 1, 2

        List<List<Integer>> sum = threeSum.threeSumSolution1(nums);
        for (List<Integer> integerList : sum) {
            Integer[] tempArrays = new Integer[integerList.size()];
            tempArrays = integerList.toArray(tempArrays);

            System.out.println(Arrays.toString(tempArrays));
        }
        System.out.println("===============================");
        List<List<Integer>> sum2 = threeSum.threeSumSolution2(nums);
        for (List<Integer> integerList : sum2) {
            Integer[] tempArrays = new Integer[integerList.size()];
            tempArrays = integerList.toArray(tempArrays);

            System.out.println(Arrays.toString(tempArrays));
        }
    }
}
