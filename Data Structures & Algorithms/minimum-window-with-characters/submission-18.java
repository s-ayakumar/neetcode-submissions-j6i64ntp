class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> s1 = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            s1.put(t.charAt(i), s1.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int formed = 0;
        int minLength = Integer.MAX_VALUE;
        String temp = "";

        for (int right = 0; right < s.length(); right++) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            if (s1.containsKey(s.charAt(right)) && window.get(s.charAt(right)) == s1.get(s.charAt(right))) {
                formed++;
            }
            int windowSize = 0;
            while (formed == s1.size()) {
                if ((s1.containsKey(s.charAt(left))) && window.get(s.charAt(left)).intValue() == s1.get(s.charAt(left)).intValue()) formed--;
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                windowSize = right - left + 1;
                if (windowSize < minLength) {
                    minLength = windowSize;
                    temp = s.substring(left, right + 1);
                }
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) return "";

        return temp;
    }
}
