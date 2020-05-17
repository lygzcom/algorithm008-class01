package algorithmtraining.fourthweek;

/**
 *
 */
public class 二分查找 {
    public static void main(String[] args) {
        // int[] nums = new int[]{1, 1, 1, 2, 3, 5, 7, 9};
        int[] nums = new int[]{1, 1, 3};
        System.out.println(search(nums, 9));
    }

    //查找数组元素
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {//结束时left=right+1
            mid = left + (right - left) / 2;//中位数取下界
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {//目标不在[left,mid] left向前靠近
                left = mid + 1;
            } else if (nums[mid] > target) {//目标不在[mid,right] right向后收缩
                right = mid - 1;
            }
        }
        //left=right+1
        // 目标在数组左边时：right一直在缩小;目标数在数组右边时，left一直在增大
        return -1;
    }

    //查找右边第一个：右边界限
    public static int searchRight(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {//结束时left=right+1
            mid = left + (right - left) / 2;//中位数取下界
            if (nums[mid] == target) {//寻找到一个左边界 left向前靠近
                left = mid + 1;
            } else if (nums[mid] < target) {//目标不在[left,mid] left向前靠近
                left = mid + 1;
            } else if (nums[mid] > target) {//目标不在[mid,right] right向后收缩
                right = mid - 1;
            }
        }
        //目标小于数组最小数，right一直在缩小，left没变
        if (left == 0) return -1;
        //目标数存在则left最后一次向前靠近加了1，目标数等于nums[left - 1]
        //目标数如果不存在，则left一直向前靠近最后left=right+1  left为nums.length越界
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    //查找左边第一个元素：左边界限
    public static int searchLeft(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {//结束时left=right+1
            mid = left + (right - left) / 2;//中位数取下界
            if (nums[mid] == target) {//寻找到一个右边界   right向后收缩
                right = mid - 1;
            } else if (nums[mid] > target) {//目标不在[mid,right]  right向后收缩
                right = mid - 1;
            } else if (nums[mid] < target) {//目标不在[left,mid]  left向前靠近
                left = mid + 1;
            }
        }
        //最后可能存在三种情况，目标在数组左边，目标在数组内部，目标在数组右边
        //left一直在向前靠近 最后left= right+1 =  nums.length,越界； 目标在数组右边
        if (left == nums.length) return -1;
        //left没有越界，那么nums[left] == target,left的位置就是第一个目标数的位置，否则目标在数组左边
        return nums[left] == target ? left : -1;
    }

}
