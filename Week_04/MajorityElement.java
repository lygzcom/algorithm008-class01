package algorithmtraining.fourthweek;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * 169. 多数元素
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int k : nums) {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }
        int max = nums[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > map.get(max)) {
                max = entry.getKey();
            }
        }
        return max;
    }

    public static int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int max = nums[0];
        for (int k : nums) {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
                if (map.get(k) > map.get(max)) {
                    max = k;
                }
            } else {
                map.put(k, 1);
            }
        }
        return max;
    }
}
