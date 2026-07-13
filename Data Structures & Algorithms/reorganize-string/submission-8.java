class Solution {
    public String reorganizeString(String s) {

        // edge cases: empty string, repeated string
        // special chars (if can't assume formatted string),
        // one string repeated with one differing letter, valid string
        
        int[] abcs = new int[26];
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            abcs[s.charAt(i) - 'a']++;
        }   

        String build = "";
        int lastCharIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            int frequency = 0;
            char curr = ' ';
            int maxIndex = -1;

            for (int j = 0; j < abcs.length; j++){
                if ((lastCharIndex == 0 || build.charAt(lastCharIndex - 1) != (char)(j + 'a')) && abcs[j] > frequency) {
                    curr = (char) (j + 'a');
                    frequency = abcs[j];
                    maxIndex = j;
                }
            }

            if (maxIndex == -1) {
                return "";
            }

            abcs[maxIndex]--;
            frequency = 0;
            build += curr;
            lastCharIndex++;

        }

        return build;




    }
}