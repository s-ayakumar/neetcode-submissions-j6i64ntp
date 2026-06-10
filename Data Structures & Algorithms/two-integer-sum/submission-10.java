class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();
        int storeArr[] = new int[2];

        for (int i = 0; i < nums.length; i++)
        {
            if (store.containsKey(target - nums[i]))
            {
                storeArr[0] = store.get(target - nums[i]);
                storeArr[1] = i;
            }
            else
            {
                store.put(nums[i], i);
            }
        }

        return storeArr;
    }
}
