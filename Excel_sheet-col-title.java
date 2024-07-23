class Solution {
    public String convertToTitle(int columnNumber) {
      // Create an empty string for storing the characters
        StringBuilder res = new StringBuilder();
// Run a while loop while columnNumber is positiv
        while (columnNumber>0){
// Subtract 1 from columnNumber
            columnNumber--;
// Get current character by doing modulo of columnNumber by 26
            char ch = (char)(columnNumber%26 + 'A');
// Divide columnNumber by 26

            columnNumber/=26;
            res.append(ch);
        }
        res.reverse();
        return res.toString();
        
    }
}
