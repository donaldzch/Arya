package string.operation;

public class Isomorphic_Strings_205 {
    public boolean isIsomorphic(String s, String t) {
        int[] c = new int[256];
        int[] d = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (c[s.charAt(i)] != d[t.charAt(i)])
                return false;
            c[s.charAt(i)] = i + 1;
            d[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
