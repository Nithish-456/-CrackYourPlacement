class Solution {
    public int maxProfit(int[] prices) {
       int n=prices.length;
       int[] v=new int[n];
       v[n-1]=prices[n-1];
       for(int i=n-2;i>=0;i--){
           v[i] = Math.max(v[i+1],prices[i]);
       } 
       int res=0;
       for(int i=0;i<n;i++){
           int curr = v[i] - prices[i];
           res = Math.max(res,curr);
       }
       return res;
    }
}
