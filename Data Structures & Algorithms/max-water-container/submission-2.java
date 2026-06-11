class Solution {
    public int maxArea(int[] heights) {
        int right = heights.length - 1;
        int left = 0;
        int max = Integer.MIN_VALUE;

        while (right > left) {
            int curr = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(max, curr);

            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return max;
    }
}
