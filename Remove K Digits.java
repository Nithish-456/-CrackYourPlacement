class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k){
            return "0";
        }
        Stack<Character> st = new Stack<>();
        for (char d:num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>d){
                    st.pop();
                    k--;
            }
            st.push(d);
        }
        while (k>0){
            st.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()){
            res.append(st.pop());
        }
        res.reverse();
        while (res.length()>1 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        return res.toString();       
    }
}
