class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] warmer = new int[temperatures.length];
        Stack<Integer> store = new Stack<>();


        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!store.isEmpty() && temperatures[i] >= temperatures[store.peek()]) {
                store.pop();
            }

            if (store.isEmpty()) {
                warmer[i] = 0;
            }
            else {
                warmer[i] = store.peek() - i;
            }

            store.push(i);
        }

        return warmer;



    }
}
