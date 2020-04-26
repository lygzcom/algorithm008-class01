package algorithmtraining.secondweek;

import java.util.Arrays;
import java.util.HashMap;

/**
 * leetcode 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println('b' - 'a');
    }

    /*
     * 判断两个串的字符是否完全相同，不考虑顺序；
     *
     * 1.排序后比较
     * 2.使用hashmap计数，遍历hashmap
     *
     *
     * */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char stemp : sArray) {
            if (map.get(stemp) != null) {
                int count = map.get(stemp) + 1;
                map.put(stemp, count);
            } else {
                map.put(stemp, 1);
            }

        }
        for (char stemp : tArray) {
            if (map.get(stemp) != null) {
                int count = map.get(stemp) - 1;
                map.put(stemp, count);
            } else {
                map.put(stemp, 1);
            }
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }

        }
        return true;
    }
}
