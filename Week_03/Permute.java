package algorithmtraining.thirdweek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
        for (List<Integer> ls : results) {
            for (Integer i : ls) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> permute(int[] nums) {
        getIntermediateResults(nums.length, nums, new Stack<>());
        return results;
    }

    private static List<List<Integer>> results = new ArrayList<>();

    public static void getIntermediateResults(int n, int[] nums, Stack<Integer> stack) {
        if (stack.size() == n) {
            results.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (stack.contains(nums[i])) continue;
            stack.push(nums[i]);
            getIntermediateResults(n, nums, stack);
            stack.pop();
        }

    }
}
