class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> closest = new ArrayList<>();
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

        int size = maxHeap.size();

        for (int i = 0; i < k; i++) {
            closest.add(maxHeap.poll());
        }

        int[][] closestArr = new int[closest.size()][];

        for (int i = 0; i < closest.size(); i++) {
            closestArr[i] = closest.get(i);
        }

        return closestArr;

    }
}
