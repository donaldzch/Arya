package priorityqueue.operation;

import java.util.*;

class Top_K_Frequent_Words_692 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> frequency = new HashMap<>();

            for (String word : words) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

                for(Map.Entry<String, Integer> entry: frequency.entrySet()){
                    pq.add(entry);
                }
            
                List<String> result = new ArrayList<>();
                while(result.size() < k) {
                    Map.Entry<String, Integer> entry = pq.poll();
                    result.add(entry.getKey());
                }
    
                return result;
        }
    }
}