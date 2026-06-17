class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] outputArr = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++)
        {
            int prev = 0;
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                prev = stack.peek();
                stack.pop();
                outputArr[prev] = i - prev;
            }
            stack.push(i);

        }

        return outputArr;

    }
}
