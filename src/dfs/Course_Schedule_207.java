package dfs;

import java.util.*;

public class Course_Schedule_207 {
    class Solution {
        //BFS topological sort
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            int[] inDegree = new int[numCourses];

            for (int i = 0; i < prerequisites.length; i++) {
                if (!graph.containsKey(prerequisites[i][0])) {
                    graph.put(prerequisites[i][0], new ArrayList<>());
                }
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
                inDegree[prerequisites[i][1]]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            int count = 0;

            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int course = queue.poll();

                if (graph.containsKey(course)) {
                    for (int c : graph.get(course)) {
                        if (--inDegree[c] == 0) {
                            queue.offer(c);
                        }
                    }
                }
                count++;
            }

            return (count == numCourses);
        }
    }

    class Solution1 {
        //DFS topological sort
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < prerequisites.length; i++) {
                if (!graph.containsKey(prerequisites[i][0])) {
                    graph.put(prerequisites[i][0], new ArrayList<>());
                }
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }

            boolean[] visited = new boolean[numCourses];
            boolean[] completed = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (completed[i])
                    continue;
                if (!dfs(i, visited, completed, graph)) {
                    return false;
                }
            }

            return true;
        }

        private boolean dfs(int course, boolean[] visited, boolean[] completed, Map<Integer, List<Integer>> graph) {
            if (completed[course])
                return true;

            if (visited[course])
                return false;

            visited[course] = true;

            if (graph.containsKey(course)) {
                for (int pre : graph.get(course)) {
                    if (!dfs(pre, visited, completed, graph)) {
                        return false;
                    }
                }
            }

            completed[course] = true;

            return true;
        }
    }
}
