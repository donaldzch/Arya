package string.operation;

public class Reverse_String_344 {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public String reverseString2(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            chars[i] = (char)(chars[i] ^ chars[j]);
            chars[j] = (char)(chars[i] ^ chars[j]);
            chars[i] = (char)(chars[i] ^ chars[j]);
            i++;
            j--;
        }
        return new String(chars);
    }
}
