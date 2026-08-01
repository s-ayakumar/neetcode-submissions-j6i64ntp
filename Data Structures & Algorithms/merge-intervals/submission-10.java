class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> output = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (output.isEmpty()) {
                output.add(intervals[i]);
            }
            else {
                if (output.get(output.size() - 1)[1] >= intervals[i][0] && output.get(output.size() - 1)[1] <= intervals[i][1]) {
                    output.get(output.size() - 1)[1] = intervals[i][1];
                }
                else if (intervals[i][1] <= output.get(output.size() - 1)[1]) {
                    continue;
                }
                else {
                    output.add(intervals[i]);
                }
            }
        }

        int[][] matrix = output.toArray(new int[output.size()][]);

        return matrix;

    }
}
