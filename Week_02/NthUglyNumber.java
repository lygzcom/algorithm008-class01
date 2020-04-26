package algorithmtraining.secondweek;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 面试题49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        for (int i = 1; i <= 1690; i++) {
            System.out.println(nthUglyNumber(i));
        }
    }

    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        List<Integer> uglyNumberArray = new ArrayList(n);
        uglyNumberArray.add(1);
        for (int i = 2; i <= n; i++) {
            getNectUglyNumber(uglyNumberArray);
        }
        return uglyNumberArray.get(n - 1);
    }

    public static void getNectUglyNumber(List<Integer> uglyNumberArray) {
        int length = uglyNumberArray.size();
        int lastNum = uglyNumberArray.get(length - 1);
        int uglyNumberProductTwo = 0;
        int uglyNumberProductThree = 0;
        int uglyNumberProductFive = 0;
        for (int temp : uglyNumberArray) {
            if (temp * 2 > lastNum && uglyNumberProductTwo == 0) {
                uglyNumberProductTwo = temp * 2;
            }
            if (temp * 3 > lastNum && uglyNumberProductThree == 0) {
                uglyNumberProductThree = temp * 3;
            }
            if (temp * 5 > lastNum && uglyNumberProductFive == 0) {
                uglyNumberProductFive = temp * 5;
            }
            if (uglyNumberProductTwo * uglyNumberProductThree * uglyNumberProductFive > 0) {
                break;
            }
        }
        int nextNum = Math.min(uglyNumberProductFive, Math.min(uglyNumberProductTwo, uglyNumberProductThree));
        uglyNumberArray.add(nextNum);

    }

    public int nthUglyNumber2(int n) {
        List<Integer> list = new ArrayList<>(n);
        list.add(1);
        int[] min = {0, 0, 0};
        for (int i = 1; i < n; i++) {
            findUN(list, i, min);
        }
        return list.get(n - 1);
    }

    private void findUN(List<Integer> list, int n, int[] min) {
        int a = 0, b = 0, c = 0;
        for (int i = min[0]; i < n; i++) {
            if (list.get(i) * 2 > list.get(n - 1)) {
                min[0] = i;
                a = list.get(i) * 2;
                break;
            }
        }
        for (int i = min[1]; i < n; i++) {
            if (list.get(i) * 3 > list.get(n - 1)) {
                min[1] = i;
                b = list.get(i) * 3;
                break;
            }
        }
        for (int i = min[2]; i < n; i++) {
            if (list.get(i) * 5 > list.get(n - 1)) {
                min[2] = i;
                c = list.get(i) * 5;
                break;
            }
        }
        list.add(Math.min(Math.min(a, b), c));
    }
}
