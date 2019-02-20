package union.find;

import java.io.IOException;
import java.util.*;

public class Accounts_Merge_721 {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            DisjointSetUnion<String> dsu = new DisjointSetUnion<>();
            Map<String, String> emailToName = new HashMap<>();
            Map<String, TreeSet<String>> unions = new HashMap<>();

            for (List<String> account : accounts) {
                String name = account.get(0);
                for (int i = 1; i < account.size(); i++) {
                    dsu.setParent(account.get(i), account.get(i));
                    emailToName.put(account.get(i), name);
                }
            }
            for (List<String> account : accounts) {
                for (int i = 2; i < account.size(); i++) {
                    dsu.union(account.get(1), account.get(i));
                }
            }
            for (List<String> account : accounts) {
                String p = dsu.find(account.get(1));
                if (!unions.containsKey(p))
                    unions.put(p, new TreeSet<>());
                for (int i = 1; i < account.size(); i++)
                    unions.get(p).add(account.get(i));
            }

            List<List<String>> res = new ArrayList<>();
            for (String p : unions.keySet()) {
                LinkedList emails = new LinkedList(unions.get(p));
                emails.addFirst(emailToName.get(p));
                res.add(emails);
            }
            return res;

        }

        class DisjointSetUnion<T> {
            private Map<T, T> parents;
            private Map<T, Integer> ranks;

            DisjointSetUnion() {
                this.parents = new HashMap<>();
                this.ranks = new HashMap<>();
            }

            public void setParent(T child, T parent) {
                parents.put(child, parent);
                ranks.put(child, 1);
            }

            public T find(T child) {
                T parent = parents.get(child);
                if (!parent.equals(child)) {
                    parent = find(parent);
                    parents.put(child, parent);
                }
                return parents.get(child);
            }

            public void union(T x, T y) {
                T parentX = find(x);
                T parentY = find(y);
                if (!parentX.equals(parentY)) {
                    int rankX = ranks.get(parentX);
                    int rankY = ranks.get(parentY);
                    if (rankX == rankY) {
                        parents.put(parentY, parentX);
                        rankX++;
                    } else if (rankX < rankY) {
                        parents.put(parentY, parentX);
                        rankX++;
                    } else {
                        parents.put(parentX, parentY);
                        rankY++;
                    }
                    ranks.put(parentX, rankX);
                    ranks.put(parentY, rankY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[][] accounts = {
                {"John", "0", "4", "3"},
                {"John", "5", "5", "0"},
                {"John", "1", "4", "0"},
                {"John", "0", "1", "3"},
                {"John", "4", "1", "3"}
        };

        List<List<String>> accountLists = new ArrayList<>();
        for (String[] account : accounts) {
            accountLists.add(Arrays.asList(account));
        }
        new Accounts_Merge_721().new Solution().accountsMerge(accountLists);


    }
}
