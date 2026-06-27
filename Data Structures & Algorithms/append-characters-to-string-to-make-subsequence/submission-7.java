class Solution {
    public int appendCharacters(String s, String t) {
        int tPointer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (tPointer == t.length()) break;
            if (s.charAt(i) == t.charAt(tPointer)) {
                tPointer++;
            }
        }

        return t.length() - tPointer;
    }
}