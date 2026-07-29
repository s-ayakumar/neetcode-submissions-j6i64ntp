class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] outputArr = new int[temperatures.length];

        Stack<Integer> store = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!store.isEmpty() && temperatures[i] >= temperatures[store.peek()]) {
                store.pop();
            }

            if (store.isEmpty()) {
                outputArr[i] = 0;
            } 
            else {
                outputArr[i] = store.peek() - i;
            }

            store.push(i);
        }
        return outputArr;
    }
}
