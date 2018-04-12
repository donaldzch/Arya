package string.operation;

public class String_Compression_443 {
    public int compress(char[] chars) {
        int length = chars.length;
        int j = 0;
        int count = 1;
        for (int i = 0; i < length; i++) {
            if (i == length - 1 || chars[i] != chars[i + 1]) {
                chars[j++] = chars[i];
                if (count != 1) {
                    for (char t : String.valueOf(count).toCharArray())
                        chars[j++] = t;
                }
                count = 1;
            } else {
                count++;
            }
        }
        return j;
    }
}
