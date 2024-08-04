class Solution {
    public int nthUglyNumber(int n) {
        if (n<=0) return 0;
        if (n<=1) return 1;
// Min-heap to get the smallest ugly number
        PriorityQueue<Long> min_heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();

        min_heap.add(1L);
        seen.add(1L);
        int[] fac = {2,3,5};
        long ugly = 1;
        for (int i=1; i<=n;i++){
// Extract the smallest ugly number
            ugly = min_heap.poll();
            // Generate new ugly numbers by multiplying with factors
            for (int factor : fac) {
                long newUgly = ugly * factor;
                if (seen.add(newUgly)) {
                    min_heap.add(newUgly);
                }
            }
        }
        return (int)ugly;      
    }
}
