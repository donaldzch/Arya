package priorityqueue.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Sort_Characters_By_Frequence_451 {
    class Solution {
        public String frequencySort(String s) {
            StringBuilder sb = new StringBuilder();

            Map<Character, Integer> frequency = new HashMap<>();

            for (char c : s.toCharArray()) {
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }

            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

            pq.addAll(frequency.entrySet());

            while (!pq.isEmpty()) {
                Map.Entry<Character, Integer> entry = pq.poll();
                for (int i = 0; i < entry.getValue(); i++) {
                    sb.append(entry.getKey());
                }
            }
            return sb.toString();
        }
    }

    class Solution1 {
        public String frequencySort(String s) {
            StringBuilder sb = new StringBuilder();

            Map<Character, Integer> frequency = new HashMap<>();

            for (char c : s.toCharArray()) {
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }

            List<Character>[] buckets = new ArrayList[s.length() + 1];

            for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
                if (buckets[entry.getValue()] == null) {
                    buckets[entry.getValue()] = new ArrayList<>();
                }
                buckets[entry.getValue()].add(entry.getKey());
            }

            for (int pos = buckets.length - 1; pos >= 0; pos--) {
                List<Character> bucket = buckets[pos];
                if (bucket != null) {
                    for (int i = 0; i < bucket.size(); i++) {
                        for (int j = 0; j < pos; j++) {
                            sb.append(bucket.get(i));
                        }
                    }
                }
            }

            return sb.toString();
        }
    }
}