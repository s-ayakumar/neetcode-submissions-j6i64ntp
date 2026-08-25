class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // return all triplets where they sum to 0 
        // sorting allows for two pointer
        // [-4, -1, -1, 0, 1, 2]
        // [l,   i,  x, x, x, r] = -4 + -1 + 2 = -3
        // []

        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[i] + nums[right] > 0) {
                    right--;
                }
                else if (nums[left] + nums[i] + nums[right] < 0) {
                    left++;
                }
                else {
                    List<Integer> currTriplet = new ArrayList<>();
                    currTriplet.add(nums[i]);
                    currTriplet.add(nums[left]);
                    currTriplet.add(nums[right]);
                    output.add(currTriplet);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--; 
                }
            }

        }

        return output;


    }
}
