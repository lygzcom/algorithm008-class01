package algorithmtraining;

import java.util.Arrays;

/**
 * @author LY
 * @version V1.0
 * @Package algorithmtraining
 * @date 2020/4/18 19:56
 * <p>
 * leetcode 26. 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组,你需要在原地删除重复出现的元素使得每个元素只出现一次返回移除后数组的新长度。
 * 不要使用额外的数组空间,你必须在 原地 修改输入数组,并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] xx = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(xx));
        System.out.println(Arrays.toString(xx));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int nonRepeatLength = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[nonRepeatLength] = nums[i];
                nonRepeatLength++;
            }

        }
        return nonRepeatLength;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int nonRepeatIndex = 0;
        int index = 1;
        while (index < nums.length) {
            if (nums[index] != nums[nonRepeatIndex]) {
                nums[++nonRepeatIndex] = nums[index];
            }
            index++;
        }
        return nonRepeatIndex + 1;
    }

}
