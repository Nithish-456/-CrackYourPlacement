class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double [n][2];
        for (int i=0;i<n;i++){
            workers[i][0] = (double) wage[i]/quality[i];
            workers[i][1]= (double) quality[i];
        }
        Arrays.sort(workers, (a,b)-> Double.compare(a[0],b[0]));
        PriorityQueue<Double> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        double quality_sum=0.0;
        double min_cost = Double.MAX_VALUE;
        for (int i=0; i<n;i++){
            double ratio = workers[i][0];
            double q = workers[i][1];
            quality_sum+=q;
            max_heap.offer(q);
            if (max_heap.size()>k){
                quality_sum-=max_heap.poll();
            }
            if (max_heap.size()==k){
                min_cost = Math.min(min_cost, quality_sum*ratio);
            }
        }
        return min_cost;
    }
}
