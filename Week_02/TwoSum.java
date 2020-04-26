package algorithmtraining.secondweek;

import java.util.Arrays;
import java.util.HashMap;

/**
 * leetcode  1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 9, 45};
        int[] result = twoSum2(nums, 13);
        System.out.println(Arrays.toString(result));
    }

    //暴力求解
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }
        }
        return null;
    }

    //利用hash求解1
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && i != map.get(temp)) {
                return new int[]{i, map.get(temp)};

            }
        }
        return null;
    }

    /**
     * 利用hash求解2 数组只存在一个解
     * 前后两个坐标是一一对应的，前面的坐标i对应的后坐标j没有加入map
     * 但是在for遍历到j时，i如果存在则一定在map里
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && i != map.get(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
