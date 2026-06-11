class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> check = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++){ 
            int[] abcs = new int[26];
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            for (int j = 0; j < curr.length; j++) {
                abcs[curr[j] - 'a']++;
            }
            String key = Arrays.toString(abcs);
            if (map.containsKey(key)) {
                check.get(map.get(key)).add(strs[i]);
            } else {
                map.put(key, check.size());
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                check.add(group);
            }
        }

        return check;
    }
}
