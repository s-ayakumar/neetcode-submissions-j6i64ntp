class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int runningMax = 0;
        int techniqueMax = 0;
        
        for (int i = 0; i < customers.length; i++)
        {
            if (grumpy[i] == 0) runningMax += customers[i];
            if (i + minutes - 1 < customers.length)
            {
                int start = i;
                int end = start + minutes;
                int curr = 0;
                while (start <= end - 1)
                {
                    if (grumpy[start] == 1)
                    {
                        curr += customers[start];
                    }
                    start++;
                }
                techniqueMax = Math.max(techniqueMax, curr);
            }
        }
        
        return techniqueMax + runningMax;

    }
}