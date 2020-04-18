package algorithmtraining;

import java.util.Arrays;

/**
 * @author LY
 * @version V1.0
 * @Package algorithmtraining
 * @date 2020/4/18 20:55
 * leetcode 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] xx = new int[]{1, 0};
        moveZeroes3(xx);
        System.out.println(Arrays.toString(xx));
    }

    public static void moveZeroes(int[] nums) {
        int temp = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                num++;
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0 && nums[j + 1] != 0) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int notZero = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                swap(nums, notZero, i);
                notZero++;
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void moveZeroes3(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int flag = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[flag++] = nums[i];
            }
        }
        for (int i = flag; i < len; i++) {
            nums[flag++] = 0;
        }
    }

    public static void moveZeroes4(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
