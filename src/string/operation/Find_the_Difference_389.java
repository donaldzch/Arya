package string.operation;

public class Find_the_Difference_389 {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);

        for (int i = 0; i < s.length(); i++) {
            c = (char)(c ^ s.charAt(i));
            c = (char)(c ^ t.charAt(i));
        }
        return c;
    }
}
