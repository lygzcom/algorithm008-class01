package algorithmtraining;

import java.util.Arrays;

/**
 * @author LY
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/4/15 12:52
 * leetcode  189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] xx = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate1(xx, 3);
        System.out.println(Arrays.toString(xx));
    }

    public static void rotate1(int[] nums, int k) {
        if (k == 0) {
            return;
        } else {
            int flag = k % nums.length;
            for (int i = 0; i < flag; i++) {
                rotateOneElement(nums);
            }
        }
    }

    public static void rotateOneElement(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }

    public static void rotate2(int[] nums, int k) {
        int flag = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, flag);
        reverse(nums, flag, nums.length);
    }

    public static void reverse(int[] nums, int start, int end) {
        int temp = 0;
        for (int i = start, j = end - 1; i < j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
