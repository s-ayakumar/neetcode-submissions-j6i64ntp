class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqs = new HashMap<>();
        int left = 0;
        int maxWindow = 0;
        int currMax = 0;
        // AAABABB // [A, 4] [B, 2]
        

        
        for (int i = 0; i < s.length(); i++) {
            freqs.put(s.charAt(i), freqs.getOrDefault(s.charAt(i), 0) + 1);
            currMax = Math.max(currMax, freqs.get(s.charAt(i)));

            while ((i - left + 1) - currMax > k) {
                if (freqs.get(s.charAt(left)) == 1) {
                    freqs.remove(s.charAt(left));
                }
                else {
                    freqs.put(s.charAt(left), freqs.get(s.charAt(left)) - 1);
                }
                left++;
            }

            maxWindow = Math.max(maxWindow, (i - left + 1));

        }

        return maxWindow;
    }
}
