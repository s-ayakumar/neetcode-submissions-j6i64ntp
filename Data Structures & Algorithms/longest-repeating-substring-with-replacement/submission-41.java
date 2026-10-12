class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int currMax = 0;
        int maxLength = 0;
        int left = 0;

        // AABABBA, k = 1
        // freq: [A, 3], [B, 1]
        // curr max = 3
        // window = 4 - 0 + 1 = 5 - 3 > k
        // 

        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            currMax = Math.max(currMax, freq.get(s.charAt(i)));

            while ((i - left + 1) - currMax > k) {
                if (freq.get(s.charAt(left)) <= 1) {
                    freq.remove(s.charAt(left));
                }
                else {
                    freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                }
                left++;
            }

            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;

    }
}
