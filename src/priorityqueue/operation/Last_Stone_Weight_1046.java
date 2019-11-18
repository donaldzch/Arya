package priorityqueue.operation;

import java.util.Comparator;
import java.util.PriorityQueue;

class Last_Stone_Weight_1046 {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int stone : stones) {
                priorityQueue.offer(stone);
            }

            while (priorityQueue.size() > 1) {
                int max = priorityQueue.poll();
                int secondMax = priorityQueue.poll();

                if (max != secondMax) {
                    priorityQueue.offer(max - secondMax);
                }
            }

            return priorityQueue.size() == 0 ? 0 : priorityQueue.poll();
        }
    }
}