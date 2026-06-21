class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        Map<Integer, Integer> store = new HashMap<>();
        store.put(0 , 1);
        

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int counter = 0;


        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(prefix[i] - goal)) {
                counter += store.get(prefix[i] - goal);
            }
            store.put(prefix[i], store.getOrDefault(prefix[i], 0) + 1);

        }

        return counter;
    }
}