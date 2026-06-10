class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int [nums.length];
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int counter = 0;

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (count.containsKey(prefix[i] - k))
            {
                counter += count.get(prefix[i] - k);
            }
            count.put(prefix[i], count.getOrDefault(prefix[i], 0) + 1);
        }


        return counter;

    }
}