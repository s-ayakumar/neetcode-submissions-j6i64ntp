class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] store = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int preCounter = 0;
        int suffCounter = nums.length - 1;


        for (int i = 0; i < nums.length; i++) {
            prefix[i] = 1;
            suffix[i] = 1;
            while (preCounter < i) {
                prefix[i] *= nums[preCounter];
                preCounter++;
            }

            while (suffCounter > i) {
                suffix[i] *= nums[suffCounter];
                suffCounter--;
            }
            store[i] = prefix[i] * suffix[i];
            preCounter = 0;
            suffCounter = nums.length - 1;
        }

        return store;

    }
}  
