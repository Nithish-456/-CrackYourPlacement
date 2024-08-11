class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');  // Handle multiple digits
            } else if (ch == '[') {
                countStack.push(k);  // Push the current multiplier to the count stack
                resultStack.push(current);  // Push the current string to the result stack
                current = new StringBuilder();  // Start a new string
                k = 0;  // Reset k
            } else if (ch == ']') {
                StringBuilder decodedString = resultStack.pop();
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    decodedString.append(current);
                }
                current = decodedString;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
