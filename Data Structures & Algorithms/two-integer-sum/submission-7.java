class Solution {
    public int[] twoSum(int[] nums, int target) {
        int difference = 0;
        Map<Integer, Integer> store = new HashMap<>();
        int[] test = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(target - nums[i])) {
                test[0] = store.get(target - nums[i]);
                test[1] = i;
            } else {
                store.put(nums[i], i);
            }
        }
        return test;
    }
}
