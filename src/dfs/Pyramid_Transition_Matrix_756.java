package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pyramid_Transition_Matrix_756 {
    class Solution {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            Map<String, List<String>> allowedMap = new HashMap<>();
            for (String allow : allowed) {
                String key = allow.substring(0, 2);
                if (!allowedMap.containsKey(key))
                    allowedMap.put(key, new ArrayList<>());
                allowedMap.get(key).add(allow.substring(2));
            }
            return dfs(bottom, allowedMap);
        }

        private boolean dfs(String bottom, Map<String, List<String>> allowedMap) {
            if (bottom.length() == 1)
                return true;

            for (int i = 0; i < bottom.length() - 1; i++) {
                if (!allowedMap.containsKey(bottom.substring(i, i + 2))) {
                    return false;
                }
            }
            List<String> bottomList = new ArrayList<>();
            getBottomList(bottom, 0, bottomList, allowedMap, new StringBuilder());
            for (String b : bottomList) {
                if (dfs(b, allowedMap)) {
                    return true;
                }
            }
            return false;
        }

        private void getBottomList(String bottom, int index, List<String> list, Map<String, List<String>> allowedMap, StringBuilder sb) {
            if (index == bottom.length() - 1) {
                list.add(sb.toString());
                return;
            }
            String sub = bottom.substring(index, index + 2);
            for (String allowed : allowedMap.get(sub)) {
                sb.append(allowed);
                getBottomList(bottom, index + 1, list, allowedMap, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
