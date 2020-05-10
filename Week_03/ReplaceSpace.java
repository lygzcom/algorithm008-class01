package algorithmtraining.thirdweek;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode  面试题05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {
    public static String replaceSpace1(String s) {
        if (s.length() == 0) {
            return "";
        }
        List<Character> strList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                strList.add('%');
                strList.add('2');
                strList.add('0');
            } else {
                strList.add(s.charAt(i));
            }

        }
        char[] strCharArray = new char[strList.size()];
        int i = 0;
        for (Character t : strList) {
            strCharArray[i++] = t;
        }
        return String.valueOf(strCharArray);
    }

    public static String replaceSpace2(String s) {
        StringBuilder str = new StringBuilder();
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == ' ') {
                str.append("%20");
            } else {
                str.append(arr[i]);
            }
        }
        return str.toString();
    }

    public static String replaceSpace3(String s) {
        StringBuilder str = new StringBuilder();
        for (char t : s.toCharArray()) {
            if (t == ' ') {
                str.append("%20");
            } else {
                str.append(t);
            }
        }
        return str.toString();
    }

    public static String replaceSpace4(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

}
