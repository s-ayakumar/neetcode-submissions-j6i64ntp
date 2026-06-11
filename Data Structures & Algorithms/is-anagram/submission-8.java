class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sFrequency = new HashMap<>();
        Map<Character, Integer> tFrequency = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        for (char c : sArr) {
            if (sFrequency.containsKey(c)) {
                sFrequency.put(c, sFrequency.get(c) + 1);
            }else {
                sFrequency.put(c, 1);
            }
        }
        for (char c : tArr) {
            if (tFrequency.containsKey(c)) {
                tFrequency.put(c, tFrequency.get(c) + 1);
            } else {
                tFrequency.put(c, 1);
            }
        }
        for (int i = 0; i < sArr.length; i++) {
            if (!(sFrequency.get(sArr[i]).equals(tFrequency.get(sArr[i])))) {
                return false;
            }
        }

        return true;
    }
}
