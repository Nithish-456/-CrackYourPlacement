class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int first = prices[0];
        int l = prices.length;
        for (int i=1;i<l;i++){
            if (first< prices[i])
            max+=prices[i] - first;
            first = prices[i];
        }
        return max;
        
    }
}
