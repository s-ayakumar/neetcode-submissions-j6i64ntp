class Solution {
    public int longestOnes(int[] nums, int k) {
        // can we assume proper binnry array input?
        // is k always a valid value i.e < 0
        // so k is the limit of how many 0's we can flip to get the longest 1 sequence

        // bf: flip every k possibilities of 0's and check 1's to store longets

        //edge cases: k = 0, k = 1, regular case, empty array, no 0's

        int max = 0;
        int currValidWindowLength = 0;
        int start = 0;
        int currKCount = 0;


        for(int i = 0; i < nums.length; i++) {
            if (currKCount <= k && nums[i] == 0) {
                currKCount++;
            }

            while (currKCount > k) {
                if (nums[start] == 0) {
                    currKCount--;
                }
                start++;
            }
            
            currValidWindowLength = i - start + 1; 
            max = Math.max(currValidWindowLength, max);
        }

        return max;

    }
}