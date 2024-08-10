class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {  // If the cell is empty
                    for (char num = '1'; num <= '9'; num++) {  // Try each number from 1 to 9
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;  // Place the number
                            
                            if (solve(board)) {  // Recursively solve the rest of the board
                                return true;
                            } else {
                                board[row][col] = '.';  // Undo the move if it doesn't lead to a solution
                            }
                        }
                    }
                    return false;  // If no number from 1 to 9 can be placed, return false
                }
            }
        }
        return true;  // If the board is completely filled, return true
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check the row, column, and 3x3 sub-box
            // row/3*3(strating row of 3*3 matrix)
            if (board[row][i] == num || board[i][col] == num || 
                board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
