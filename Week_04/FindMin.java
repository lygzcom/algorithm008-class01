package algorithmtraining.fourthweek;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMin {
    public static void main(String[] args) {
        // int[] nums = new int[]{1, 1, 1, 2, 3, 5, 7, 9};
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        /*
         * 查找有序数组中的最小元素
         *
         * 边界条件 数组为空返回-1;数组不存在重复元素
         * 数组存在旋转情况；
         * 目前情况：mid为中点 ，z为突变点
         * z在left~mid之间(nums[left]>=nums[mid]) 所以mid到right为升序序列 nums[mid]最小 收缩right=mid-1;
         * z在left~mid之外(nums[left]<=nums[mid]) 所以此序列有序，nums[left]最小，增加left=mid+1
         * */
        int left = 0, right = nums.length - 1, mid = 0;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[left] > nums[mid]) {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
            if (nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            }

        }
        return min;
    }
}
