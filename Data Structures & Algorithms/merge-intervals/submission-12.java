class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> finalIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (finalIntervals.isEmpty() || finalIntervals.get(finalIntervals.size() - 1)[1] < intervals[i][0]) {
                finalIntervals.add(intervals[i]);
            }
            else if (finalIntervals.get(finalIntervals.size() - 1)[1] >= intervals[i][0]) {
                int start = finalIntervals.get(finalIntervals.size() - 1)[0];
                int end = finalIntervals.get(finalIntervals.size() - 1)[1];
                finalIntervals.remove(finalIntervals.size() - 1);
                finalIntervals.add(new int[] {start, Math.max(end, intervals[i][1])});
            }
            else {
                continue;
            }
        }

        int[][] matrix = finalIntervals.toArray(new int[finalIntervals.size()][]);

        return matrix;



    }
}
