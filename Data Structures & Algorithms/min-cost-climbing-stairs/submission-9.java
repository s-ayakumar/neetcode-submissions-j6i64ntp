class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length + 1];
        cache[0] = cost[0];
        cache[1] = cost[1];

        // min(dfs(i + 1), dfs(i + 2)) -> min(dfs(0), dfs(1))?
        for (int i = 2; i < cost.length; i++)
        {
            cache[i] = cost[i] + Math.min(cache[i - 1], cache[i - 2]);
        }


        return Math.min(cache[cost.length - 1], cache[cost.length - 2]);

    }
}
