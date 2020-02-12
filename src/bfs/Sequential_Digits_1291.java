package bfs;

import java.util.*;

class Sequential_Digits_1291 {
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> result = new ArrayList<>();

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i < 10; i++) {
                q.offer(i);
            }

            while (!q.isEmpty()) {
                int value = q.poll();
                if (low <= value && value <= high) {
                    result.add(value);
                }
                int lastDigit = value % 10;
                if (lastDigit < 9) {
                    int newValue = value * 10 + lastDigit + 1;
                    if (newValue <= high) {
                        q.offer(newValue);
                    }
                }
            }

            return result;
        }
    }
}