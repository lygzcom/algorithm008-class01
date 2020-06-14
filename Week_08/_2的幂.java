package algorithmtraining.第八周;

/**
 * @author LY
 * @version V1.0
 * @Package algorithmtraining.第八周
 * @date 2020/6/14 18:54
 */
public class _2的幂 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
