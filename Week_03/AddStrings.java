package algorithmtraining.thirdweek;

import java.util.Arrays;

/**
 * leetcode 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 *
 * @author LY
 * @version V1.0
 * @Package algorithmtraining.thirdweek
 * @date 2020/4/28 22:33
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("999", "999"));
    }

    public static String addStrings(String num1, String num2) {
        char[] longNumStr, shortNumStr;
        if (num1.length() >= num2.length()) {
            longNumStr = num1.toCharArray();
            shortNumStr = num2.toCharArray();
        } else {
            longNumStr = num2.toCharArray();
            shortNumStr = num1.toCharArray();

        }
        char[] theSum = new char[longNumStr.length + 1];
        int flag = 0, temp = 0;
        for (int i = 1; i <= longNumStr.length; i++) {
            if (i <= shortNumStr.length) {
                temp = longNumStr[longNumStr.length - i] - '0' + shortNumStr[shortNumStr.length - i] - '0'+flag;

            } else {
                temp = longNumStr[longNumStr.length - i] - '0' + flag;
            }
            theSum[theSum.length - i] = (char) (temp % 10 + '0');
            flag = temp / 10;
        }
        if (flag == 0) {
            return String.valueOf(theSum, 1, theSum.length - 1);
        } else {
            theSum[0] = '1';
            return String.valueOf(theSum);
        }

    }

}
