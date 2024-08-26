class Solution {
    public int[][] minCashFlow(int[][] transaction, int n) {
        // Calculate net amount for each person
        int[] netAmount = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                netAmount[i] += (transaction[j][i] - transaction[i][j]);
            }
        }
        
        // Create a new result matrix
        int[][] result = new int[n][n];
        
        // Settle debts
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (netAmount[i] < 0 && netAmount[j] > 0) {
                    int amount = Math.min(-netAmount[i], netAmount[j]);
                    result[i][j] = amount;
                    netAmount[i] += amount;
                    netAmount[j] -= amount;
                }
            }
        }
        
        return result;
    }
}
