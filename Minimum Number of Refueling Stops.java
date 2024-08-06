class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel>=target){
            return 0;
        }
        // maximum fuel capacity is at the top of the heap
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        int i=0, refuel=0;
        int n = stations.length;
        int d = startFuel;
        while (d<target){
            if (i < n && stations[i][0] <= d) {
                max_heap.add(stations[i][1]);
                i++;
            }
            else if (max_heap.isEmpty()){
                return -1;
            }
            else{
                d+=max_heap.poll();
                refuel++;
            }
        }
        return refuel;
    }
}
