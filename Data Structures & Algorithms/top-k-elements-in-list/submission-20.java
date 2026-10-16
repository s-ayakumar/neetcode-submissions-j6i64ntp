class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        Map<Integer, Integer> freqs = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            freqs.put(nums[i], freqs.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> curr : freqs.entrySet()) {
            minHeap.offer(curr);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while(!minHeap.isEmpty()) {

            result.add(minHeap.poll().getKey());
        }

        int[] res = new int[result.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;

    }
}
