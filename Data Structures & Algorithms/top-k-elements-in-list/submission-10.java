class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> frequencies = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            
            frequencies.put(nums[i], frequencies.getOrDefault(nums[i], 0) + 1);
        }

        minHeap.addAll(frequencies.entrySet());
        
        while (minHeap.size() > k) {
            minHeap.poll();
        }

        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            list.add(entry.getKey());
        }

        int[] output = new int[list.size()];

        for (int i = 0; i < output.length; i++) {
            output[i] = list.get(i);
        }

        return output;


    }
}
