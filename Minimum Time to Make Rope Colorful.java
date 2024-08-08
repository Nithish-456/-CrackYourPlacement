class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time=0;
        int n = colors.length();
        for (int i=1;i<n;i++){
            if (colors.charAt(i) == colors.charAt(i-1)){
                // we can remove the ballon with minimum time needed
                time += Math.min(neededTime[i], neededTime[i-1]);
                // and we will keep another ballon with max time for further
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return time;
        
    }
}
