class Solution {
    public int characterReplacement(String s, int k) {
        
        // Given a string s of only upper case chars
        // choose k chars of the string and replace them w/ any other english char
        // output: length of longest substring which only has one unique char

        // Key insight: track the frequencies of the chars in the window
        // window length - maxFreq > k : window invalid


        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i),             map.getOrDefault(s.charAt(i), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(i)));

            while ((i - left + 1) - maxFreq > k) {
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                }
                else {
                    map.remove(s.charAt(left));
                }
                left++;
            }

            maxWindow = Math.max(maxWindow, (i - left + 1));

        }

        return maxWindow;



        
    }
}
