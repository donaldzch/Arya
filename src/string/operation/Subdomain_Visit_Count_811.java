package string.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Subdomain_Visit_Count_811 {
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            List<String> result = new ArrayList<>();

            Map<String, Integer> map = new HashMap<>();

            for (String cpdomain : cpdomains) {
                String[] cp = cpdomain.split("\\s+");
                int count = Integer.valueOf(cp[0]);
                String[] domains = cp[1].split("\\.");
                String currentDomain = "";
                for (int i = domains.length - 1; i >=0; i--) {
                    currentDomain = domains[i] + ((i < domains.length - 1) ? "." : "") + currentDomain;
                    map.put(currentDomain, map.getOrDefault(currentDomain, 0) + count);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                result.add(entry.getValue() + " " + entry.getKey());
            }

            return result;
        }
    }
}