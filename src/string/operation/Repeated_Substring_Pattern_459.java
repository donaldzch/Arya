package string.operation;

public class Repeated_Substring_Pattern_459 {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        char[] chars = s.toCharArray();

        for (int i = length / 2; i > 0; i--) {
            if (length % i == 0) {
                int j = i;
                for (; j < length; j += i) {
                    int k = 0;
                    for (; k < i; k++) {
                        if (chars[k] != chars[k + j])
                            break;
                    }
                    if (k != i)
                        break;
                }
                if (j == length)
                    return true;
            }
        }
        return false;
    }
}
