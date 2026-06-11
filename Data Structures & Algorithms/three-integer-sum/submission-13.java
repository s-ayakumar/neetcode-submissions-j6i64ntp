class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnArr = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == -(nums[i])) {
                    returnArr.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;

                } else if (nums[j] + nums[k] > -(nums[i])) {
                    k--;
                    continue;
                } else if (nums[j] + nums[k] < -(nums[i])) {
                    j++;
                    continue;
                } else {
                    j++;
                    k--;
                }
            }
        }
        
        return returnArr;

    }
}
