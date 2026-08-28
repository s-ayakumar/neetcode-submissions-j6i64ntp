class Solution {
    public int characterReplacement(String s, int k) {
        // trick: window size - maxFreq >= k
        // 4 - 2 >= 2
        // 5 - 3 >= 1

        Map<Character, Integer> frequencyMap = new HashMap<>();
        int currMax = 0;
        int left = 0;
        int longestWindow = 0;

        for (int i = 0; i < s.length(); i++) {
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
            currMax = Math.max(currMax, frequencyMap.get(s.charAt(i)));

            while ((i - left + 1) - currMax > k) {
                if (frequencyMap.get(s.charAt(left)) == 1) {
                    frequencyMap.remove(s.charAt(left));
                }
                else {
                    frequencyMap.put(s.charAt(left), frequencyMap.get(s.charAt(left)) - 1);
                }
                left++;
            }

            longestWindow = Math.max(longestWindow, i - left + 1);
        }

        return longestWindow;


    }
}
