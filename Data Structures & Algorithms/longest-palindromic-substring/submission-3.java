class Solution {
    public String longestPalindrome(String s) {
        String dp = "";

        for (int i = 0; i < s.length(); i++)
        {
            String evenCurr = expand(i, i + 1, s);
            String oddCurr = expand(i, i, s);
            String curr;
            if (evenCurr.length() > oddCurr.length())
            {  
                curr = evenCurr;
            }
            else
            {
                curr = oddCurr;
            }
            if (curr.length() > dp.length())
            {
                dp = curr;
            }

        }

        return dp;
    }

    private String expand (int left, int right, String s)
    {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right))
        {
            right++;
            left--;
        }

        return s.substring(left + 1, right);

    }
}
