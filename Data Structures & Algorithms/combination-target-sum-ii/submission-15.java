class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, sums, 0);
        return result;
    }

    private void dfs (int[] candidates, int target, List<List<Integer>> results, List<Integer> sums, int start)
    { 
        if (target < 0) return;
        if (target == 0) 
        {
            results.add(new ArrayList<>(sums));
            return;
        }
        for (int i = start; i < candidates.length; i++)
        {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            sums.add(candidates[i]);
            dfs(candidates, target - candidates[i], results, sums, i + 1);
            sums.remove(sums.size() - 1);
        }

        
    }
}
