class KthLargest {

    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++)
        {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k)
        {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
