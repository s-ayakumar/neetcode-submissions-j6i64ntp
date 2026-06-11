class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, result, subset, nums);

        return result;
    }

    private void dfs (int i, List<List<Integer>> result, List<Integer> subset, int[] nums)
    {
        if (i >= nums.length) 
        {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i + 1, result, subset, nums);
        subset.remove(subset.size() - 1);
        int curr = nums[i];
        while (i < nums.length && curr == nums[i])
        {
            i++;
        }
        dfs(i, result, subset, nums);
    }
}
