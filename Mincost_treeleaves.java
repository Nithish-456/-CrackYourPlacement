class Solution {
    public int mctFromLeafValues(int[] arr) {
        if (arr==null || arr.length<2){
            return 0;
        }
        int res=0;
        Stack<Integer> st = new Stack<>();
        for (int n:arr){
            while(!st.isEmpty() && st.peek()<=n){
                int mid = st.pop();
                if (st.isEmpty())
                    res+=mid*n;
                else
                    res+=mid*Math.min(st.peek(), n);
            }
            st.push(n);
        }
        while (st.size()>1){
            res+=st.pop() * st.peek();
        }
        return res;      
    }
}
