class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> currentCombination = new ArrayList<>();
        dfs(nums, 0, target, currentCombination, output);

        return output;
    }

    private void dfs (int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> output) {
        if (target == 0) {
            output.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                curr.add(nums[i]);
                dfs(nums, i, target - nums[i], curr, output);
                curr.remove(curr.size() - 1);
            }
        }

    }

}
