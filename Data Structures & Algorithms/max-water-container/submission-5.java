class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;


        while (right > left)
        {
            if (heights[right] > heights[left])
            {
                max = Math.max(max, heights[left] * (right - left));
                left++;
            }
            else if (heights[left] > heights[right]) 
            {
                max = Math.max(max, heights[right] * (right - left));
                right--;
            }
            else
            {
                max = Math.max(max, heights[left] * (right - left));
                right--;
                left++;
            }
        }

        return max;
    }
}
