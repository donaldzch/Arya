package treemap;

import java.util.*;

class Time_Based_Key_Value_Store_981 {
    class TimeMap {

        /** Initialize your data structure here. */

        private Map<String, TreeMap<Integer, String>> map;
        public TimeMap() {
            map = new HashMap<>();
        }
        
        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>());
            }
            map.get(key).putIfAbsent(timestamp, value);
        }
        
        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treemap = map.get(key);

            if (treemap == null) {
                return "";
            }

            Integer t = treemap.floorKey(timestamp);
            return t == null ? "" : treemap.get(t);
        }
    }
}