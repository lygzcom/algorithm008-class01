package algorithmtraining.secondweek;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * leetcode 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(Arrays.toString(topKFrequent(nums, 1)));
    }

    //利用hashmap计算出每个元素频率   按频率排序
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2);
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int temp = map.get(nums[i]) + 1;
                map.put(nums[i], temp);
            } else {
                map.put(nums[i], 1);
            }

        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> frequencySortQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (frequencySortQueue.size() < k) {
                frequencySortQueue.add(key);
            } else if (map.get(key) > map.get(frequencySortQueue.peek())) {
                frequencySortQueue.remove();
                frequencySortQueue.add(key);
            }
        }
        // 取出最小堆中的元素
        int flag = 0;
        while (!frequencySortQueue.isEmpty()) {
            result[flag++] = frequencySortQueue.remove();
        }
        return result;
    }
}
