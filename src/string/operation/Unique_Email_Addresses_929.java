package string.operation;

import java.util.HashSet;
import java.util.Set;

public class Unique_Email_Addresses_929 {
    class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> set = new HashSet<>();

            for (String email : emails) {
                String[] parts = email.split("@");
                String local = getLocal(parts[0]);
                String domain = parts[1];
                set.add(local + "@" + domain);
            }

            return set.size();
        }

        private String getLocal(String part) {
            char[] chars = part.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                if (c != '.') {
                    if (c == '+') {
                        break;
                    }
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
