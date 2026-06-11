class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int listIndex = 0;
        mergedIntervals.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++)
        {
            int[] temp = mergedIntervals.get(listIndex);
            if (temp[1] >= intervals[i][0])
            {
                temp[0] = Math.min(intervals[i][0], temp[0]);
                temp[1] = Math.max(intervals[i][1], temp[1]);
            }
            else 
            {
                mergedIntervals.add(intervals[i]);
                listIndex++;
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

    }
}
