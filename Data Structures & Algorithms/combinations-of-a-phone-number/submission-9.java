class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> store = new ArrayList<>();
        String[] map = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
        };

        dfs(store, map, digits, 0, "");

        return store;
    
    }

    private void dfs (List<String> store, String[] map, String digits, int i, String combo)
    {
        if (digits.isEmpty()) return;
        if (i > digits.length() - 1) 
        {
            store.add(combo);
            return;
        }
        int curr = digits.charAt(i) - '0';
        String currLetterSet = map[curr];

        for (int j = 0; j < currLetterSet.length(); j++)
        {
            dfs(store, map, digits, i + 1, combo + currLetterSet.charAt(j));
        }

    }
}
