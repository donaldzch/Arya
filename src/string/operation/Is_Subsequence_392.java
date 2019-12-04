package string.operation;

class Is_Subsequence_392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            for (int i = 0, j = 0; i < s.length() && j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                } 
            }
            
            return i == s.length();
        }
    }
}