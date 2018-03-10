import java.util.*;

public class Letter_Case_Permutation_784 {
    public List<String> letterCasePermutation(String S) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i)))
                continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }

    public List<String> letterCasePermutation1(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        backTracking(S, res, 0);
        return res;
    }

    public void backTracking(String s, List<String> res, int pos) {
        if (pos == s.length()) {
            res.add(s);
            return;
        }
        if (Character.isDigit(s.charAt(pos))) {
            backTracking(s, res, pos + 1);
        } else {
            char[] chs = s.toCharArray();
            chs[pos] = Character.toLowerCase(chs[pos]);
            backTracking(String.valueOf(chs), res, pos + 1);

            chs[pos] = Character.toUpperCase(chs[pos]);
            backTracking(String.valueOf(chs), res, pos + 1);
        }
    }
}
