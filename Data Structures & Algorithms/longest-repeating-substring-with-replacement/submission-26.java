class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqs = new HashMap<>();
        int currMax = 0;
        int left = 0;
        int longestWindow = 0;


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

            longestWindow = Math.max(i - left + 1, longestWindow);
        }
        
        return longestWindow;


    }
}
