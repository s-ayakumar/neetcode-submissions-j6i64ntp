class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        Map<Integer, Integer> store = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            store.put(nums[i], store.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : store.keySet()) {
            int frequency = store.get(key);
            int groups = frequency / 3;
            int rem = frequency % 3;

            if (frequency == 1) return -1;

            if (rem == 0) {
                count += groups;
            }
            else if (rem == 1) {
                count += (groups - 1) + 2;
            }
            else if (rem == 2) {
                count += groups + 1;
            }
        }

        return count;

    }
}