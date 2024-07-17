class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        direc = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, 1], [1, -1], [-1, 1], [-1, -1]]
        live =0
        change={}
        def valid(r,c):
            return (0<=r<rows) and (0<=c<cols)

        for r in range(rows):
            for c in range(cols):
                live=0
                for dr,dc in direc:
                    new_r, new_c = r+dr, c+dc
                    if valid(new_r,new_c) and board[new_r][new_c] == 1:
                        live+=1
                if board[r][c] == 1:
                    if live<2 or live>3:
                        change[(r,c)] = 0
                else:
                    if live == 3:
                        change[(r,c)] = 1
        for (r,c),nextstate in change.items():
            board[r][c] = nextstate

        
