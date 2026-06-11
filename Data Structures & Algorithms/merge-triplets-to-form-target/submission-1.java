class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] runningTarget = new int[3];

        for (int i = 0; i < triplets.length; i++)
        {
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2])
            {
                continue;
            }

            if (triplets[i][0] == target[0] && triplets[i][1] == target[1] && triplets[i][2] == target[2]) return true;

            if (i == 0)
            {
                runningTarget[0] = triplets[i][0];
                runningTarget[1] = triplets[i][1];
                runningTarget[2] = triplets[i][2];
                if (runningTarget[0] == target[0] && runningTarget[1] == target[1] && runningTarget[2] == target[2]) return true;
            }
            
            runningTarget[0] = Math.max(triplets[i][0], runningTarget[0]);
            runningTarget[1] = Math.max(triplets[i][1], runningTarget[1]);
            runningTarget[2] = Math.max(triplets[i][2], runningTarget[2]);
        }

        return runningTarget[0] == target[0] && runningTarget[1] == target[1] && runningTarget[2] == target[2];
    }
}
