import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int num = 0;
        for (char i : J.toCharArray()) {
            for (char j: S.toCharArray()) {
                if (i == j) {
                    num++;
                }
            }
        }
        return num;
    }

    public int numJewelsInStones1(String J, String S) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j: J.toCharArray()) setJ.add(j);
        for (char s: S.toCharArray()) if (setJ.contains(s)) res++;
        return res;
    }

    public int numJewelsInStones2(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
}
