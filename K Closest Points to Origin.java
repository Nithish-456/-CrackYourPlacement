class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> max_heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return Integer.compare(distance(point2), distance(point1));
            }
        });
        // Add points to the heap, maintaining only the k closest points
        for (int[] p : points) {
            max_heap.offer(p);
            if (max_heap.size() > k) {
                max_heap.poll(); // Remove the farthest point if heap size exceeds k
            }
        }
        int[][] result = new int[k][2];
        int index = 0;
        while (!max_heap.isEmpty()) {
            result[index++] = max_heap.poll();
        }       
        return result;       
    }
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
