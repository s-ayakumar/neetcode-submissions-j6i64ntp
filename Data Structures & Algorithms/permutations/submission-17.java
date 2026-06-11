class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, 0);
        return result;
    }

    private void dfs (List<List<Integer>> result, int[] nums, int i)
    {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            result.add(list);
            return;
        }
        for(int j = i; j < nums.length; j++)
        {
            swap(nums, i, j);
            dfs(result, nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap (int[] arr, int i, int j)
    {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
