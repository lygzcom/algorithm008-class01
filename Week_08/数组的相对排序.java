package algorithmtraining.第八周;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author LY
 * @version V1.0
 * @Package algorithmtraining
 * @date 2020/6/10 23:50
 */
public class 数组的相对排序 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] b = new int[]{2, 1, 4, 3, 9, 6};
        relativeSortArray(a, b);

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int[] ans = new int[arr1.length];
        for (int i : arr2) {
            set.add(i);
        }
        int startIndex = 0;
        for (int i = 0; i < arr2.length; ) {
            int count = map.get(arr2[i]);
            if (count-- > 0) {
                ans[startIndex++] = arr2[i];
                map.put(arr2[i], count);
            } else {
                i++;
            }
        }
        int index = 0, start = startIndex;
        int[] temp = new int[arr1.length - start];
        for (int i : arr1) {
            if (!set.contains(i)) {
                temp[index++] = i;
            }
        }
        Arrays.sort(temp);
        for (int i : temp) {
            ans[start++] = i;
        }
        return ans;
    }
}
