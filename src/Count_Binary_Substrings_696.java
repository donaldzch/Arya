public class Count_Binary_Substrings_696 {

    public int countBinarySubstring(String s) {
        int prevLength = 0, curLength = 1;
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                curLength++;
            else {
                // "0" to "1" or "1" to "0"
                prevLength = curLength;
                curLength = 1;
            }
            if (prevLength >= curLength)
                // prevLength > curLength means change "X01" "X0011" "X000111", etc
                // prevLength = curLength means change "01" "0011" "000111", etc
                count++;
        }
        return count;
    }
}
