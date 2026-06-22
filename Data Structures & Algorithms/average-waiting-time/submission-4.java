class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time = customers[0][0] + customers[0][1];
        double waitingTimes = time - customers[0][0];

        for (int i = 1; i < customers.length; i++) {
            int arrival = customers[i][0];
            int cookTime = customers[i][1];

            if (time < arrival) {
                waitingTimes += cookTime;
                time = arrival + cookTime;
            }
            else {
                waitingTimes += cookTime - arrival + time;
                time = cookTime + time;
            }
        }

        return (waitingTimes / (double) customers.length);
    }
}