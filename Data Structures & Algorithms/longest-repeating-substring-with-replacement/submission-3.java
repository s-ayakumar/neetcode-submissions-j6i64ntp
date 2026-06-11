class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0;
        int countMax = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

            max = Math.max(max, freq.get(s.charAt(right)));
            int currWindow = right - left + 1;
            if (currWindow - max > k) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            } 

            countMax = Math.max(right - left + 1, countMax);
            
        }

        return countMax;

    }
}
