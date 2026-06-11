class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> dms = new Stack<>();
        int[] store = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--)
        {
            while (!dms.isEmpty() && temperatures[i] >= temperatures[dms.peek()])
            {
                dms.pop();
            }
            if (dms.isEmpty())
            {
                dms.push(i);
                store[i] = 0;
            }
            else 
            {
                store[i] = dms.peek() - i;
                dms.push(i);
            }
        }

        return store;
    }
}
