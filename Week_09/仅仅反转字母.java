package algorithmtraining.第九周;


public class 仅仅反转字母 {
    public static String reverseOnlyLetters(String S) {
        String reverseStr = "";
        if (S == null || S.length() == 0) {
            return S;
        } else {
            char[] charArray = S.toCharArray();
            for (int i = 0, j = charArray.length - 1; i <= j; ) {
                if (isLetter(charArray[i])) {
                    if (isLetter(charArray[j])) {
                        char temp = charArray[i];
                        charArray[i] = charArray[j];
                        charArray[j] = temp;
                        i++;
                        j--;
                    } else {
                        j--;
                    }

                } else {
                    i++;
                }

            }
            reverseStr = String.valueOf(charArray);
        }
        return reverseStr;
    }

    public static boolean isLetter(char c) {
        //97 122  小写a-z
        // 65 90  大写A-Z
        if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) {
            return true;
        } else {
            return false;
        }

    }
}
