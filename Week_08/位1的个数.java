package algorithmtraining.第八周;

/**
 * @author LY
 * @version V1.0
 * @Package algorithmtraining.第八周
 * @date 2020/6/14 18:53
 */
public class 位1的个数 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
