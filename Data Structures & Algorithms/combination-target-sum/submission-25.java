class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        // dfs call
        dfs (nums, target, output, temp, 0);


        return output;
                                       
    }


    private void dfs (int[] nums, int target, List<List<Integer>> output, List<Integer> temp, int index) {

        if (target == 0) {
            output.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                temp.add(nums[i]);
                dfs(nums, target - nums[i], output, temp, i);
                temp.remove(temp.size() - 1);
            }
        }


    }
    

    

}
