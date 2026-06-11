class Solution {
    public boolean isPalindrome(String s) {
        String dupe = s;
        dupe = dupe.toLowerCase();
        dupe = dupe.replaceAll("\\s", "");
        dupe = dupe.replaceAll("[^a-z0-9]", "");


        int left = 0;
        int right = dupe.length() - 1;

        while (left < right) {
            if (dupe.charAt(left) != dupe.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
