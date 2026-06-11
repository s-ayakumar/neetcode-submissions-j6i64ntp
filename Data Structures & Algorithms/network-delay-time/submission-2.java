class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> timesLookup = new HashMap<>();

        for (int[] time : times)
        {
            timesLookup.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
        minHeap.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int t = 0; // length to visit last node

        while (!minHeap.isEmpty())
        {
            int[] curr = minHeap.poll();
            if (visited.contains(curr[1])) continue;
            visited.add(curr[1]);
            t = curr[0];

            if (timesLookup.containsKey(curr[1]))
            {
                for (int[] next : timesLookup.get(curr[1]))
                {
                    if (!visited.contains(next[0]))
                    {
                        minHeap.offer(new int[]{curr[0] + next[1], next[0]});
                    }
                }
            }

        }
        if (visited.size() == n)
        {
            return t;
        }
        return -1;
    }
}
