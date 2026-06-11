class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int left = 0;
        int max = 1;

        Set<Character> freq = new HashSet<>();
        freq.add(s.charAt(left));

        for (int right = 1; right < s.length(); right++) {
            while (freq.contains(s.charAt(right))) {
                freq.remove(s.charAt(left));
                left++;
            }
            freq.add(s.charAt(right));
            int curr = right - left + 1;
            max = Math.max(curr, max);
        }

        return max;
    }
}
