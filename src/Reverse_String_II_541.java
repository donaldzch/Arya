public class Reverse_String_II_541 {
    public String reverseStr(String s, int k) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        for (int start = 0; start < chars.length; start += 2 * k) {
            int left = start, right = Math.min(start + k - 1, chars.length - 1);
            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }
        return String.valueOf(chars);
    }
}
