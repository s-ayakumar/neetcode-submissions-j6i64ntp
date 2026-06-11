class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int[] suffix = new int[height.length];
        int[] prefix = new int[height.length];
        int maxS = 0;
        int maxP = 0;
        int area = 0;
        
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                maxP = height[i];
                prefix[i] = maxP;
            }
            else if (height[i] > maxP) {
                maxP = height[i];
                prefix[i] = maxP;
            } else {
                prefix[i] = maxP;
            }
        }
        
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                maxS = height[i];
                suffix[i] = maxS;
            } else if (height[i] > maxS) {
                maxS = height[i];
                suffix[i] = maxS;
            } else {
                suffix[i] = maxS;
            }
        }

        for (int i = 0; i < height.length; i++) {
            area += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return area;
    }
}
