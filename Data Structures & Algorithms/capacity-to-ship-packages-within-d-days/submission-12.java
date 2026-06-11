class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int high = 0;
        int low = 0;
        for (int i = 0;i < weights.length; i++)
        {
            high += weights[i];
            low = Math.max(weights[i], low);
        }
        return binarySearch(weights, days, low, high);
    }

    private int binarySearch(int[] weights, int days, int low, int high)
    {
        if (low == high) return low;
        int mid = (low + high) / 2;
        
        boolean checkMid = check(mid, weights, days);
        int lowest = high;
        if (checkMid) 
        {
            return binarySearch(weights, days, low, mid);
        }
        else 
        {
            return binarySearch(weights, days, mid + 1, high);
        }
    }

    private boolean check(int mid, int[] weights, int days)
    {
        int currWeightDays = 1;
        int runningDailySum = 0;

        for (int i = 0; i < weights.length; i++)
        {
            if (runningDailySum + weights[i] > mid)
            {
                runningDailySum = weights[i];
                currWeightDays++;
            }
            else
            {
                runningDailySum += weights[i];
            }
        }
        
        return currWeightDays <= days;
    }
}