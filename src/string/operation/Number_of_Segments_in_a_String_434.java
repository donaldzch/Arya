package string.operation;

public class Number_of_Segments_in_a_String_434 {
    public int countSegments(String s) {
        int count = 0;
        if (s == null) {
            return count;
        }
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ((i == 0 || chars[i - 1] == ' ') && chars[i] != ' ') {
                count++;
            }
        }

        return count;
    }
}
