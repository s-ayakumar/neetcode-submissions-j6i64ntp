class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        dfs(output, nums, target, curr, 0);
        
        return output;
    }

    private void dfs (List<List<Integer>> output, int[] nums, int target, List<Integer> curr, int start) {
        if (target == 0) {
            output.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                curr.add(nums[i]);
                dfs(output, nums, target - nums[i], curr, i);
                curr.remove(curr.size() - 1);
            }
        }

    }

    

}
