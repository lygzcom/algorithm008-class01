package algorithmtraining.fourthweek;

import java.util.HashMap;

/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/
 */
public class LemonadeChange {
    public static void main(String... ars) {
        int[] nums = new int[]{5,5,10,10,5,20,5,10,5,5};
        System.out.println(lemonadeChange(nums));

    }

    public static boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                map.put(5, map.get(5) + 1);
            } else if (bills[i] == 10) {
                if (map.get(5) >= 1) {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) + 1);
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (map.get(5) >= 1 && map.get(10) >= 1) {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);
                    continue;
                }
                if (map.get(5) >= 3) {
                    map.put(5, map.get(5) - 3);
                    continue;
                }
                return false;
            }

        }
        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}
