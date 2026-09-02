class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] closest = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];

            return Integer.compare(distB, distA);
        });

        for (int i = 0; i < points.length; i++) {
            maxHeap.add(points[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            closest[i] = maxHeap.poll();
        }

        return closest;

    }
}
