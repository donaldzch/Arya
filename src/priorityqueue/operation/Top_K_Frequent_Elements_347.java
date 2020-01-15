package priorityqueue.operation;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Top_K_Frequent_Elements_347 {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequency = new HashMap<>();

            for (int num : nums) {
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq = 
                         new PriorityQueue<>((a, b)-> (b.getValue() - a.getValue()));
            for(Map.Entry<Integer,Integer> entry: frequency.entrySet()){
                pq.add(entry);
            }
        
            List<Integer> result = new ArrayList<>();
            while(result.size() < k) {
                Map.Entry<Integer, Integer> entry = pq.poll();
                result.add(entry.getKey());
            }

            return result;
        }
    }

    class Solution1 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequency = new HashMap<>();

            for (int num : nums) {
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            }

            List<Integer>[] buckets = new ArrayList[nums.length + 1];

            for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
                if (buckets[entry.getValue()] == null) {
                    buckets[entry.getValue()] = new ArrayList<>();
                }
                buckets[entry.getValue()].add(entry.getKey());
            }

            List<Integer> result = new ArrayList<>();

            for (int pos = buckets.length - 1; pos >= 0 && k > 0; pos--) {
                if (buckets[pos] != null) {
                    result.addAll(buckets[pos]);
                    k -= buckets[pos].size();
                }
            }

            return result;
        }
    }
}