class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int storeIndex = 0;
        List<int[]> newIntervals = new ArrayList<>();
        int i = 0;


        while (i < intervals.length && intervals[i][1] < newInterval[0])
        {
            newIntervals.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        newIntervals.add(newInterval);

        while (i < intervals.length)
        {
            newIntervals.add(intervals[i]);
            i++;
        }

        return newIntervals.toArray(new int[newIntervals.size()][]);


    }
}
