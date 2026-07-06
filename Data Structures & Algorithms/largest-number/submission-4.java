class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        int largest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
            s[i] = String.valueOf(nums[i]);
        }

        if (largest == 0) return "0";        

        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));

        String str = "";
        for (int i = 0; i < nums.length; i++) {
            str += s[i];
        }

        return str;
    }
}