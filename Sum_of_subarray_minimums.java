class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        Stack<Integer> st = new Stack<>();
        int j,k;
        for (int i=0;i<=n;i++){
            while (!st.isEmpty() && arr[st.peek()] > (i==n ? Integer.MIN_VALUE:arr[i])){
                j=st.pop();
                k=st.isEmpty()?-1:st.peek();
                res+= (long)arr[j] * (i - j) * (j - k);
            }
            st.push(i);
        }
        return (int)(res%(long)(1e9+7));
        
    }
}
