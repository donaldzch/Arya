package trie;

import java.util.*;

class Short_Encoding_of_Words_820 {
    class Solution {
        public int minimumLengthEncoding(String[] words) {
            int result = 0;

            TrieNode root = new TrieNode();

            Map<TrieNode, Integer> map = new HashMap<>();

            TrieNode current;

            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                current = root;

                for (int j = word.length() - 1; j >= 0; j--) {
                    current = current.get(word.charAt(j));
                }
                map.put(current, i);
            }

            for (TrieNode node : map.keySet()) {
                if (node.count == 0) {
                    result += words[map.get(node)].length() + 1;
                }
            }

            return result;
        }

        private class TrieNode {
            TrieNode[] children;
            int count;

            public TrieNode() {
                this.children = new TrieNode[26];
                this.count = 0;
            }

            public TrieNode get(char c) {
                if (children[c - 'a'] == null) {
                    children[c - 'a'] = new TrieNode();
                    count++;
                }
                return children[c - 'a'];
            }
        }
    }
}