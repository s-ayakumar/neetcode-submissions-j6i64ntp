class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        // n people in a line numbered from 0 to n - 1 (indexes)
        // we are given heights where heights[i] is height of ith person in line
        // assuming valid heights (non-negative)
        // output is array of integers that represent the farthest the ith person can look right from their position

        // bf: for each person traverse right to see the max reach

        // more efficient approach: monotonic stack

        // edge case: empty heights, negative heights, empty one height, normal case
        
        Stack<Integer> heightIndex = new Stack<>();

        int[] storeHeights = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!heightIndex.isEmpty() && heights[i] > heights[heightIndex.peek()]) {
                storeHeights[i]++;
                heightIndex.pop();
            }

            if (!heightIndex.isEmpty()) {
                storeHeights[i]++;
            }


            heightIndex.push(i);
        }

        return storeHeights;




    }
}