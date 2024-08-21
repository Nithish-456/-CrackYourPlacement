class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;      
        int rows = matrix.length;
        int cols = matrix[0].length;       
        // Create a histogram array
        int[] heights = new int[cols];
        int max_area = 0;       
        // Build the histogram row by row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Update the histogram based on current row
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }           
            // Calculate the maximum rectangle in the histogram for the current row
            max_area = Math.max(max_area, helper(heights));
        }
        
        return max_area;
    }
    
    // Function to calculate the largest rectangle area in a histogram
    private int helper(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        int n = heights.length;       
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];           
            // Maintain a stack that stores the indices of the bars in increasing height order
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max_area = Math.max(max_area, height * width);
            }            
            stack.push(i);
        }       
        return max_area;
    }
}
