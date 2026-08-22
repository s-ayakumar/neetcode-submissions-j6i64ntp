class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] warmer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();


        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                warmer[i] = 0;
            } else {
                warmer[i] = stack.peek() - i;
            }

            stack.push(i);

        }


        return warmer;




    }
}
