class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> outputArr = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } 
                else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }
                else {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[left]);
                    curr.add(nums[right]);
                    outputArr.add(curr);
                    left++;
                    right--;
                    while (left < nums.length && nums[left] == nums[left - 1]) left++;
                    while (right > 0 && nums[right] == nums[right + 1]) right--;
                }


            }

        }


        return outputArr;


    }
}
