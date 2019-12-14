package rabinkarp;

class Repeated_String_Match_686 {
    class Solution {
        public int repeatedStringMatch(String A, String B) {
            StringBuilder sb = new StringBuilder();

            int count = 0;

            for (; sb.length() < B.length(); count++) {
                sb.append(A);
            }

            if (sb.toString().contains(B)) {
                return count;
            }

            if (sb.append(A).toString().contains(B)) {
                return count + 1;
            }
            return -1;
        }
    }
}