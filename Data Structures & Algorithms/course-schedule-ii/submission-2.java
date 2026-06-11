class Solution {
    private int top;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] store = new ArrayList[numCourses];
        top = numCourses - 1;
        for (int i = 0; i < numCourses; i++)
        {
            store[i] = new ArrayList<>();
        }

        for(int[] classFlow : prerequisites)
        {
            store[classFlow[1]].add(classFlow[0]);
        }

        int[] result = new int[numCourses];
        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentPath = new HashSet<>();

        for (int i = 0; i < numCourses; i++)
        {
            if(!visited.contains(i))
            {
                if (!dfs(i, currentPath, visited, store, result)) return new int[0];
            }
        }

        return result;
    }
    private boolean dfs (int course, Set<Integer> currentPath, Set<Integer> visited, List<Integer>[] store, int[] result)
    {
        if (currentPath.contains(course)) return false;
        if (visited.contains(course)) return true;

        currentPath.add(course);

        for (int nextCourse : store[course])
        {
            if(!dfs(nextCourse, currentPath, visited, store, result)) return false;
        }

        visited.add(course);
        result[top] = course;
        top--;
        currentPath.remove(course);

        return true;
        
    }
    


}
