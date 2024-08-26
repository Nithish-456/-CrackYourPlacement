
class Solution {
    // Function to calculate the number of spanning trees
    public static int countSpanningTrees(int[][] graph, int n, int m) {
        // Create the Laplacian matrix
        int[][] laplacian = new int[n][n];

        // Construct the Laplacian matrix
        for (int i = 0; i < m; i++) {
            int u = graph[i][0];
            int v = graph[i][1];

            laplacian[u][u]++;
            laplacian[v][v]++;
            laplacian[u][v]--;
            laplacian[v][u]--;
        }

        // We remove the first row and column (cofactor of Laplacian)
        int[][] cofactorMatrix = new int[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                cofactorMatrix[i - 1][j - 1] = laplacian[i][j];
            }
        }

        // Calculate the determinant of the cofactor matrix
        return determinant(cofactorMatrix, n - 1);
    }

    // Function to calculate the determinant of a matrix
    private static int determinant(int[][] matrix, int n) {
        if (n == 1) {
            return matrix[0][0];
        }

        int det = 0;
        int[][] temp = new int[n][n];
        int sign = 1;

        for (int f = 0; f < n; f++) {
            getCofactor(matrix, temp, 0, f, n);
            det += sign * matrix[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }

        return det;
    }

    // Function to get the cofactor of a matrix
    private static void getCofactor(int[][] matrix, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = matrix[row][col];

                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
}

        
