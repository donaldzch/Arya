package math.operation;

import java.util.*;

class Rabbits_in_Forest_781 {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> count = new HashMap<>();
            int result = 0;

            for(int answer : answers) {
                count.put(answer, count.getOrDefault(answer, 0) + 1);
            }

            for (int key : count.keySet()) {
                int group = count.get(key) / (key + 1);
                result += count.get(key) % (key + 1) == 0 ? group * (key + 1) : (group + 1) * (key + 1); 
            }

            return result;
        }
    }
}