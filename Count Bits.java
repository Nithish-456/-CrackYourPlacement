class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i=1;i<=n;i++){
            res[i] = res[i>>1] + (i&1);  // i&1 - if LSB is odd means we will add 1 or else nothin
        }
        return res;
    }
}
