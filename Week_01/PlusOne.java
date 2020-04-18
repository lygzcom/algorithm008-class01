package algorithmtraining;

import java.util.Arrays;

/**
 * @author LY
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/4/13 14:13
 * leetcode 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] xx = new int[]{1,2,3};
        System.out.println(Arrays.toString(plusOne(xx)));

    }

    public static int[] plusOne(int[] digits) {
        int[] plusOneIntArray = new int[digits.length + 1];
        int temp = 1;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + temp;
            if (sum < 10) {
                plusOneIntArray[i + 1] = sum;
                temp = 0;
            } else {
                plusOneIntArray[i + 1] = 10 - sum;
                temp = 1;
            }
        }
        if (temp == 0) {
            return Arrays.copyOfRange(plusOneIntArray, 1, plusOneIntArray.length);
        } else {
            plusOneIntArray[0] = 1;
            return plusOneIntArray;
        }

    }

    public static int[] plusOne1(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

}
