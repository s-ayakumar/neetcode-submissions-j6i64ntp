class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> store = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!store.isEmpty() && heights[i] >= heights[store.peek()])
            {
                store.pop();
            } 
            store.push(i);
        }

        int[] storeArrInt = new int[store.size()];

        for (int i = 0; i < store.size(); i++)
        {
            storeArrInt[i] = store.get(i);
        }


        return storeArrInt; 


    }
}