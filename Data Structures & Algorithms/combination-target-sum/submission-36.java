class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        dfs(nums, target, output, curr, 0);

        return output;

    }

    private void dfs (int[] nums, int target, List<List<Integer>> output, List<Integer> curr, int i) {

        if (target == 0) {
            output.add(new ArrayList<>(curr));
            return;
        }

        for (int c = i; c < nums.length; c++) {
            if (target - nums[c] >= 0) {
                curr.add(nums[c]);
                dfs(nums, target - nums[c], output, curr, c);
                curr.remove(curr.size() - 1);
            }
        }
        
    }
}
