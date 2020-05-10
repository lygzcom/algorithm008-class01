package algorithmtraining.thirdweek;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

    }

    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        generate_Parenthesis(0, 0, n, new StringBuilder(), results);
        return results;

    }

    public static void generate_Parenthesis(int left, int right, int n, StringBuilder str, List<String> results) {
        if (left == n && right == n) {
            results.add(str.toString());
            return;
        }
        if (left < n) {
            generate_Parenthesis(left + 1, right, n, new StringBuilder(str).append("("), results);
        }
        if (right < left) {
            generate_Parenthesis(left, right + 1, n, new StringBuilder(str).append(")"), results);
        }

    }

}
