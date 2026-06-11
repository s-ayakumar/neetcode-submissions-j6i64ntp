class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int [26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int[] newArr = new int[26];

        for (int right = 0; right < s2.length(); right++) {
            newArr[s2.charAt(right) - 'a']++;
            int windowLen = right - left + 1;
            if (windowLen > s1.length()) {
                newArr[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(arr, newArr)) {
                return true;
            }
            
        }

        return false;
    }
}
