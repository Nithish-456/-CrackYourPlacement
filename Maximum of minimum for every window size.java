class Solution 
{
    static int[] maxOfMin(int[] arr, int n) 
    {
        int[] left = new int[n];
        int[] right= new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right, n);
        
        Stack<Integer> st = new Stack<>();
        // Fill the elements of left[]
        for (int i=0; i<n; i++){
            while (!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                left[i]=st.peek();
            }
            st.push(i);
        }
        while (!st.isEmpty()){
            st.pop();
        }
        // Fill elements of right[]
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                right[i] = st.peek();
            }
            st.push(i);
        }
        int[] res = new int[n + 1];
        Arrays.fill(res, 0);
        // Fill answer array by comparing minimums of all windows
        for (int i = 0; i < n; i++) {
            // Length of the interval in which arr[i] is minimum
            int len = right[i] - left[i] - 1;
            res[len] = Math.max(res[len], arr[i]);
        }
        // Fill the rest of the entries in the answer array
        for (int i = n - 1; i >= 1; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            result[i - 1] = res[i];
        }
        return result;
        
    }
    
    
}
