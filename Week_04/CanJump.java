package algorithmtraining.fourthweek;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {
    /* 从前往后遍历判断：
     *  对于任意可达位置i，i+nums[i]的位置也都可达到；
     *  记录最远可达位置，越过时更新；
     *  无法越过则返回；
     * */
    public boolean canJump(int[] nums) {
        //最大可行走步数
        int maxSteps = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSteps = maxSteps - 1;
            maxSteps = Math.max(maxSteps, nums[i]);
            if (maxSteps == 0 && i != nums.length - 1) {
                return false;
            }
            if (i + maxSteps >= nums.length - 1) return true;
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        //最远位置
        int maxPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxPosition) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (maxPosition >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {
        //最远位置
        int maxPosition = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > maxPosition) return false;
            maxPosition = Math.max(maxPosition, i + nums[i]);
        }
        return true;
    }

}
