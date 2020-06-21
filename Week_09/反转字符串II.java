package algorithmtraining.第九周;


public class 反转字符串II {

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return s;
        char[] charArray = s.toCharArray();
        int twoK = 2 * k;
        int lastnums = s.length() % twoK;
        int flag = s.length() - lastnums;
        char temp;
        for (int i = 0; i < flag; i = i + twoK) {
            for (int p = i, q = i + k - 1; p < q; p++, q--) {
                temp = charArray[p];
                charArray[p] = charArray[q];
                charArray[q] = temp;
            }
        }
        if (lastnums < k) {
            for (int p = flag, q = s.length() - 1; p < q; p++, q--) {
                temp = charArray[p];
                charArray[p] = charArray[q];
                charArray[q] = temp;
            }
        } else {
            for (int p = flag, q = flag + k - 1; p < q; p++, q--) {
                temp = charArray[p];
                charArray[p] = charArray[q];
                charArray[q] = temp;
            }

        }

        return new String(charArray);
    }
}
