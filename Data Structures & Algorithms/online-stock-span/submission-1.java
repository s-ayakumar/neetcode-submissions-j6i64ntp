class StockSpanner {

    private Stack<int[]> store;

    public StockSpanner() {
        store = new Stack<>();

    }
    
    public int next(int price) {
        int span = 1;
        if (store.isEmpty()) 
        {
            store.push(new int[]{price, span});
            return span;
        } 
        
        if (price < store.peek()[0]) 
        {
            store.push(new int[]{price, span});
            return span;
        }

        while (!store.isEmpty() && price >= store.peek()[0]) 
        {
            span += store.peek()[1];
            store.pop();
        }

        store.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */