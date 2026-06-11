class Solution {
    public int longestConsecutive(int[] nums) {
        Set <Integer> container = new HashSet<>();
        int counter = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            container.add(nums[i]);
        }

        for (int num : nums) {
            if (!container.contains(num - 1)) {
                counter++;
                while (container.contains(num + counter)) {
                    counter++;
                }
                max = Math.max(counter, max);
                counter = 0;
            }
        }

        return max;
    }
}
