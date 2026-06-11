class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        Map<Integer, Integer> storeRemainders = new HashMap<>();
        storeRemainders.put(0, -1);

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            prefix[i] = prefix[i - 1] + nums[i];
        }


        for (int i = 0; i < prefix.length; i++)
        {
            if (storeRemainders.containsKey(prefix[i] % k) && i - storeRemainders.get(prefix[i] % k) >= 2) 
            {
                return true;
            }
            if (!storeRemainders.containsKey(prefix[i] % k))
            {
                storeRemainders.put(prefix[i] % k, i);
            }   
        }


        return false;

    }
}