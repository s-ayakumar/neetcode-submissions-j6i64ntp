class KthLargest {
    int K;
    List<Integer> add;

    public KthLargest(int k, int[] nums) {
        K = k;
        add = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            add.add(nums[i]);
        }

    }
    
    public int add(int val) {
        add.add(val);
        Collections.sort(add);
        return add.get(add.size() - K);
    }
}
