class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> frequencyList = new ArrayList<>();
        Map<Character, Integer> storage = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (!storage.containsKey(s.charAt(i)))
            {
                storage.put(s.charAt(i), i);
            }
            else
            {
                storage.put(s.charAt(i), i);
            }

        }

        int size = 0;
        int start = 0;
        int lastIndex = 0;

        for (int i = 0; i < s.length(); i++)
        {
            lastIndex = Math.max(lastIndex, storage.get(s.charAt(i)));
            if (i == lastIndex)
            {
                frequencyList.add(size + 1);
                start = i + 1;
                size = 0;
            }
            else
            {
                size = i - start + 1;
            }
            
        }

        return frequencyList;

    }
}
