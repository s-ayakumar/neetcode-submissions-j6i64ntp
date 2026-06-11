class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> duplicate = new HashSet<>();
            for (int num : nums) {
                if (duplicate.contains(num)) {
                    return true;
                }
                duplicate.add(num);
            }
        return false;
    }
}