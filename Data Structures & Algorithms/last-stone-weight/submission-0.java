class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++)
        {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1)
        {
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();

            if (largest - secondLargest == 0)
            {
                continue;
            }
            else
            {
                largest = largest - secondLargest;
                maxHeap.add(largest);
            }
        }

        if (maxHeap.isEmpty()) return 0;
        
        return maxHeap.poll();
    }
}
