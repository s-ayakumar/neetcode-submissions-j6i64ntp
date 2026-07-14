class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // given three integers as parameters
        // output contains only 'a', 'b', 'c'
        // output contains no 'aaa', 'bbb', 'ccc' substrings
        // a occurences of 'a', b occurences of 'b', etc.

        // BF: check every possibility against each other -> O(abc)^2
        // Alternative: use maxheap to store largest frequency letter and pop from that



        String build = "";

        int[] freqs = new int[3];

        freqs[0] = a;
        freqs[1] = b;
        freqs[2] = c;

        

        for (int i = 0; i < a + b + c; i++) {
            char curr = ' ';
            char best = ' ';
            int freq = 0;
            int index = -1;
            for (int j = 0; j < freqs.length; j++) {
                curr = (char)(j + 'a');
                if (build.length() >= 2 && build.charAt(build.length() - 1) == curr && build.charAt(build.length() - 2) == curr) {
                    continue;
                }
                if (freqs[j] > freq && freqs[j] > 0) {
                    freq = freqs[j];
                    best = curr;
                    index = j;
                }
            }

            if (index == -1) break;

            build += best;
            freqs[index]--;
        }

        return build;
    }
}