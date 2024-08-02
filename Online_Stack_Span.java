class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int res=1;
        while (st.size()>0 && st.peek()[0]<=price){
            res+=st.pop()[1];
        }
        st.push(new int[]{price,res});
        return res;
        
    }
}
