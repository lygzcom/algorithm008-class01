package algorithmtraining.fourthweek;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3};
        System.out.println(search(nums, 2));
    }


    /* 数组有序可以通过二分查找
     * 设mid为中间数  z为转折点 目标t
     * z在  0 ~ mid之间
     *               mid ~ 0 为递增序列
     *                     t在此区间可省略0 ~ mid
     *                     t不在此区间可省略 mid ~ 0
     * z在  mid ~ len之间
     *              0 ~ mid 为递增序列
     *                   t在此区间可省略 mid ~ len
     *                   t不在此区间可省略 0 ~ mid
     * */

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
