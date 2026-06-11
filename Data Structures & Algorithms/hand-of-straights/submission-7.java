class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        if (hand.length % groupSize != 0) return false;
        
        Map<Integer, Integer> store = new HashMap<>();

        for (int i = 0; i < hand.length; i++)
        {
            if (!store.containsKey(hand[i]))
            {
                store.put(hand[i], 1);
            }
            else
            {
                store.put(hand[i], store.get(hand[i]) + 1);
            }
            
        }

        for (int i = 0; i < hand.length; i++)
        {
            if (store.get(hand[i]) == 0) continue;
            int curr = hand[i];
            int size = 1;
            store.put(curr, store.get(curr) - 1);
            while (size < groupSize)
            {
                if (store.getOrDefault(curr + 1, 0) > 0)
                {
                    store.put(curr + 1, store.get(curr + 1) - 1);
                }
                else
                {
                    return false;
                }
                curr = curr + 1;
                size++;
            }
        }

        return true;
    }
}
