class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isope(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(evaluate(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }      
        return stack.pop();
    }   
    private boolean isope(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }   
    private int evaluate(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}
