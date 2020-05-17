package algorithmtraining.fourthweek;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int max = 0, t = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < g.length; i++) {
            for (int j = t; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    max++;
                    t = j + 1;
                    break;
                }

            }
        }
        return max;
    }

}
