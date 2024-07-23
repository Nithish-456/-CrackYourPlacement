class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        circles = int(len(matrix)/2)
        rows = columns = len(matrix)
        start_row = start_column = 0
        end_row = end_column = rows-1
        for l in range(0, circles):
            i = start_row
            for j in range(start_column, end_column):
                left_top = matrix[i][j]
                matrix[i][j] = matrix[end_row-j+start_row][start_column]
                matrix[end_row-j+start_row][start_column] = matrix[end_row][end_column + start_column - j]
                matrix[end_row][end_column + start_column - j] = matrix[j][end_column]
                matrix[j][end_column] = left_top
            start_row += 1
            start_column += 1
            end_row -= 1
            end_column -= 1
        
