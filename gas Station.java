class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0, total_cost=0;
        int st =0, tank=0;
        for (int i=0;i<gas.length;i++){
            total_gas+=gas[i];
            total_cost+=cost[i];
        }
        if (total_gas<total_cost){
            return -1;
        }
        for (int i=0;i<gas.length;i++){
            tank+=gas[i]-cost[i];
            if (tank<0){
                st=i+1;
                tank=0;
            }
        }
        return st;
    }
}
