class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st = new Stack<>();
        for (char ch:S.toCharArray()){
            if (Character.isDigit(ch)){
                st.push(ch-'0');
            }else{
                int val2=st.pop();
                int val1=st.pop();
                
                switch(ch){
                    case '+':
                        st.push(val1 + val2);
                        break;
                    case '-':
                        st.push(val1 - val2);
                        break;
                    case '*':
                        st.push(val1 * val2);
                        break;
                    case '/':
                        st.push(val1 / val2);
                        break;
                }
            }
        }
        return st.pop();
    }
}
