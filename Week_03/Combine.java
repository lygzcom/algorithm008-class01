package algorithmtraining.thirdweek;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {
    public static void main(String[] args) {
        combine(3, 3);
        for (List<Integer> ls : results) {
            for (Integer i : ls) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> results = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        if (n < k || k == 0) {
            return results;
        }
        getIntermediateResults(1, k, n, new Stack<>());
        return results;
    }

    public static void getIntermediateResults(int start, int k, int n, Stack<Integer> stack) {
        if (stack.size() == k) {
            results.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= n; i++) {
            stack.push(i);
            getIntermediateResults(i + 1, k, n, stack);
            stack.pop();
        }

    }

}
