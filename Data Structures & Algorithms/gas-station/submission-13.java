class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < cost.length; i++)
        {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (costSum > gasSum) return -1;

        int total = gas[0] - cost[0];
        int maxIndex = 0;
        for (int i = 1; i < gas.length; i++)
        {
            if (total < 0)
            {
                total = gas[i] - cost[i];
                maxIndex = i;
            }
            else 
            {
                total += gas[i] - cost[i];
            }

        }

        return maxIndex;
    }
}
