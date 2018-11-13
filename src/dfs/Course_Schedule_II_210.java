package dfs;

import java.util.*;

public class Course_Schedule_II_210 {
    class Solution {
        //BFS topological sort
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> graph = new HashMap<>();

            int[] indegrees = new int[numCourses];

            int[] ans = new int[numCourses];
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();

            for (int[] prerequisite : prerequisites) {
                if (!graph.containsKey(prerequisite[1])) {
                    graph.put(prerequisite[1], new ArrayList<>());
                }
                graph.get(prerequisite[1]).add(prerequisite[0]);
                indegrees[prerequisite[0]]++;
            }

            for (int i = 0; i < numCourses; i++) {
                if (indegrees[i] == 0) {
                    queue.offer(i);
                    ans[count++] = i;
                }
            }

            while (!queue.isEmpty()) {
                int course = queue.poll();
                if (graph.containsKey(course)) {
                    for (int c : graph.get(course)) {
                        indegrees[c]--;
                        if (indegrees[c] == 0) {
                            queue.offer(c);
                            ans[count++] = c;
                        }
                    }
                }
            }

            if (count == numCourses) {
                return ans;
            } else {
                return new int[0];
            }
        }
    }

    class Solution1 {
        //DFS topological sort
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // to represent the status of visit
            // 0 means unvisited
            // 1 means being visited to capture cycle
            // 2 means visited
            int[] visited = new int[numCourses];

            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int i = 0; i < numCourses; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            }

            int[] res = new int[numCourses];

            Stack<Integer> stack = new Stack<>();

            for (int course = 0; course < numCourses; course++) {
                if (visited[course] == 0) {
                    if (!dfs(course, visited, graph, stack)) {
                        return new int[0];
                    }
                }
            }

            int index = 0;

            while (!stack.isEmpty()) {
                res[index++] = stack.pop();
            }

            return res;
        }

        //hasCycle
        private boolean dfs(int course, int[] visited, Map<Integer, List<Integer>> graph, Stack<Integer> stack) {
            if (visited[course] == 2)
                return true;

            if (visited[course] == 1)
                return false;

            visited[course] = 1;
            for (int c : graph.get(course)) {
                if (!dfs(c, visited, graph, stack)) {
                    return false;
                }
            }

            visited[course] = 2;
            stack.push(course);
            return true;
        }
    }
}
