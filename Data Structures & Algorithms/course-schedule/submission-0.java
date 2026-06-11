class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites)
        {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
        {
            if (inDegree[i] == 0) queue.add(i);
        }

        return bfs(queue, inDegree, adj, numCourses);
    }
    private boolean bfs(Queue<Integer> q, int[] inDegree, List<List<Integer>> adj, int numCount)
    {
        int count = 0;
        while (!q.isEmpty())
        {
            count++;
            int course = q.poll();
            for (int neighbor : adj.get(course))
            {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                {
                    q.add(neighbor);
                }
            }
        }

        return count == numCount;
    }

}
