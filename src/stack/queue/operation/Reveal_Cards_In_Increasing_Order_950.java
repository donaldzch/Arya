package stack.queue.operation;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Reveal_Cards_In_Increasing_Order_950 {
    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < deck.length; i++) {
                deque.add(i);
            }

            Arrays.sort(deck);

            int[] result = new int[deck.length];

            for (int i = 0; i < deck.length; i++) {
                result[deque.poll()] = deck[i];
                deque.add(deque.poll());
            }

            return result;
        }
    }
}
