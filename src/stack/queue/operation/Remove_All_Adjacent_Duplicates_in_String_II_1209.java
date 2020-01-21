package stack.queue.operation;

import java.util.Map;
import java.util.Stack;
import javafx.util.Pair;

class Remove_All_Adjacent_Duplicates_in_String_II_1209 {
    class Solution {
        public String removeDuplicates(String s, int k) {
            Stack<Pair<Character, Integer>> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty()) {
                    Pair<Character, Integer> pair = stack.peek();
                    if (pair.getKey() == s.charAt(i)) {
                        int count = pair.getValue() + 1;
                        if (count == k) {
                            stack.pop();
                        } else {
                            stack.pop();
                            stack.push(new Pair<Character,Integer>(pair.getKey(), count));
                        }
                    } else {
                        stack.push(new Pair<Character,Integer>(s.charAt(i), 1));
                    }
                } else {
                    stack.push(new Pair<Character,Integer>(s.charAt(i), 1));
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                Pair<Character, Integer> pair = stack.pop();
                for (int i = 0; i < pair.getValue(); i++) {
                    sb.append(pair.getKey());
                }
            }
            return sb.reverse().toString();
        }
    }
}