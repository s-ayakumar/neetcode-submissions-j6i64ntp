class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int runningMax = 0;
        int techniqueMax = 0;
        int window = 0;

        int start = 0;
        
        for (int i = 0; i < customers.length; i++)
        {
            if (i >= minutes)
            {
                if (grumpy[i - minutes] == 1)
                {
                    window -= customers[i - minutes];
                }
            }
            if (grumpy[i] == 1)
            {
                window += customers[i];
            }
            if (grumpy[i] == 0) runningMax += customers[i];

            techniqueMax = Math.max(techniqueMax, window);
            
        }
        
        return techniqueMax + runningMax;

    }
}