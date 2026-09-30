class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // should store based on a single key value pair in a map
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freqs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqs.put(nums[i], freqs.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> curr : freqs.entrySet()) {
            minHeap.offer(curr);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().getKey());
        }

        int[] result = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;



    }
}
