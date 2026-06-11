class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();

        dfs(nums, target, result, sums, 0);
        return result;
    }

    private void dfs(int[] nums, int target, List<List<Integer>> result, List<Integer> sums, int start)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(sums));
            return;
        }
        if (target < 0) {
            return;
        } 

        for (int i = start; i < nums.length; i++)
        {
            sums.add(nums[i]);
            dfs(nums, target - nums[i], result, sums, i);
            sums.remove(sums.size() - 1);
        }

    }
}
