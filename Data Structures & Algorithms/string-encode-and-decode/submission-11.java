class Solution {

    public String encode(List<String> strs) {
        String build = "";
        for (int i = 0; i < strs.size(); i++) {
            int num = strs.get(i).length();
            build += num + "#" + strs.get(i);
        }

        return build;
    }

    public List<String> decode(String str) {
        List<String> store = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            store.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }

        return store;
    }
}
