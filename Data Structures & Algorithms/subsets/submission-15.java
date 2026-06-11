class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(0, subset, nums, result);

        return result;
    }

    private void dfs (int i, List<Integer> subset, int[] nums, List<List<Integer>> result)
    {
        if (i >= nums.length) 
        {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i + 1, subset, nums, result);
        subset.remove(subset.size() - 1);
        dfs(i + 1, subset, nums, result);

    }
}
