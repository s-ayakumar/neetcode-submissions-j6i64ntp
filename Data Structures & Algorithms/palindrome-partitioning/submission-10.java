class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> possibilities = new ArrayList<>();
        List<String> substring = new ArrayList<>();

        dfs(possibilities, substring, s, 0);

        return possibilities;
    }

    private void dfs (List<List<String>> possibilities, List<String> substring, String s, int i)
    {
        if (s.length() == i) 
        {
            possibilities.add(new ArrayList<>(substring));
            return;
        }
        
        
        for (int start = i; start < s.length(); start++)
        {
            if (isPalindrome(s.substring(i, start + 1)))
            {
                substring.add(s.substring(i, start + 1));
                dfs(possibilities, substring, s, start + 1);
                substring.remove(substring.size() - 1);
            }
        }

    }

    private boolean isPalindrome (String s)
    {
        int left = 0;
        int right = s.length() - 1;

        while (left < right)
        {
            if (s.charAt(left) != s.charAt(right)) return false;
            right--;
            left++;
        }
        return true;
    }
}
