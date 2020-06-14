package algorithmtraining.第八周;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LY
 * @version V1.0
 * @Package algorithmtraining.第八周
 * @date 2020/6/13 21:45
 * 面试题40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class getLeastNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 1};
        getLeastNumbers1(nums, 3);

    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length < 1) return arr;
        if (k <= 0) return new int[0];
        int[] result = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }

    public static int[] getLeastNumbers1(int[] arr, int k) {
        int[] result = new int[k];
        quickPick(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static void quickPick(int[] arr, int startIndex, int endIndex, int k) {
        int basenum = arr[startIndex];
        int temp = 0, left = startIndex, right = endIndex;
        while (left < right) {
            while (right > left && arr[right] >= basenum) {
                right--;
            }
            while (left < right && arr[left] <= basenum) {
                left++;
            }
            {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

        }
        if (right == left) {
            temp = arr[right];
            arr[right] = arr[startIndex];
            arr[startIndex] = temp;
            if (right == k) {
                return;
            } else if (right < k && right + 1 < endIndex) {
                quickPick(arr, right + 1, endIndex, k);
            } else if (right > k && startIndex < right - 1) {
                quickPick(arr, startIndex, right - 1, k);
            }

        }
    }
}
