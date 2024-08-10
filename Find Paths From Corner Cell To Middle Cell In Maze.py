def findPathInMazeUtil(maze, path, visited, curr):
    # If we have reached the destination cell.
    # print the complete path
    if curr[0] == N // 2 and curr[1] == N // 2:
        printPath(path)
        return
    # consider each direction
    for i in range(4):
        # get value of current cell
        n = maze[curr[0]][curr[1]]
        # We can move N cells in either of 4 directions
        x = curr[0] + row[i]*n
        y = curr[1] + col[i]*n
        next = (x, y)
        # if valid pair
        if isValid(visited, next):
            # mark cell as visited
            visited.append(next)
            # add cell to current path
            path.append(next)
            # recurse for next cell
            findPathInMazeUtil(maze, path, visited, next)
            # backtrack
            # remove cell from current path
            path.pop()
            visited.remove(next)
def findPathInMazeUtil(maze, path, visited, curr):
    # If we have reached the destination cell.
    # print the complete path
    if curr[0] == N // 2 and curr[1] == N // 2:
        printPath(path)
        return
    # consider each direction
    for i in range(4):
        # get value of current cell
        n = maze[curr[0]][curr[1]]
        # We can move N cells in either of 4 directions
        x = curr[0] + row[i]*n
        y = curr[1] + col[i]*n
        next = (x, y)
        # if valid pair
        if isValid(visited, next):
            # mark cell as visited
            visited.append(next)
            # add cell to current path
            path.append(next)
            # recurse for next cell
            findPathInMazeUtil(maze, path, visited, next)
            # backtrack
            # remove cell from current path
            path.pop()
            visited.remove(next)
