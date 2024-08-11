class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        # Iterating rows and columns
        r, c = len(grid), len(grid[0])
        # Intiation of islands
        islands=0
        # Defining a function for Depth First Search
        def nis(i,j):
            # Checking condition for out of bounds
            if i<0 or i>=r or j<0 or j>=c or grid[i][j]=='0':
                return
            grid[i][j] = '0'  # Marking current cell as visited one 
            nis(i+1, j)   # Recursion function for down direction
            nis(i-1, j)   # Recursion function for up direction
            nis(i, j+1)   # Recursion function for right direction
            nis(i, j-1)   # Recursion function for left direction

        for i in range(r):
            for j in range(c):
                if grid[i][j] == '1':
                    islands+=1   # If island found means we have to increment the count of islands
                    nis(i,j)    # Recursion function to check adjacent cells in the grid
        return islands
        
