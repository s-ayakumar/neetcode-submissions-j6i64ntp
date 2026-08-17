class Solution {
    public int characterReplacement(String s, int k) {
        // given s consisting of only uppercase letters
        // choose up to k chars of s and replace w any other char
        // return length of longest substring which contains only one distinct char
        // purpose: make the longest string of same chars 

        Map<Character, Integer> frequencies = new HashMap<>();

        int left = 0;
        int max = 0;
        int maxFreq = 0;

        for (int i = 0; i < s.length(); i++) {

            frequencies.put(s.charAt(i), frequencies.getOrDefault(s.charAt(i), 0) + 1);

            maxFreq = Math.max(maxFreq, frequencies.get(s.charAt(i)));

            while ((i - left + 1) - (maxFreq) > k) {
                if (frequencies.get(s.charAt(left)) > 0) {
                    frequencies.put(s.charAt(left), frequencies.get(s.charAt(left)) - 1);
                } else {
                    frequencies.remove(s.charAt(left));
                }
                left++;
            }

            max = Math.max(i - left + 1, max);
        }

        return max;
    }
}
