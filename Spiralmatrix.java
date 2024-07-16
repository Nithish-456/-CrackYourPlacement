class Solution {
    enum Dir {
        RIGHT, DOWN, LEFT, UP
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int x = 0, y = 0;
        boolean[][] visited = new boolean[rows][cols];
        Dir dir = Dir.RIGHT;
        int total = rows * cols;

        while (res.size() < total) {
            res.add(matrix[x][y]);
            visited[x][y] = true;

            switch (dir) {
                case RIGHT:
                    if (y + 1 < cols && !visited[x][y + 1]) {
                        y++;
                    } else {
                        dir = Dir.DOWN;
                        x++;
                    }
                    break;

                case DOWN:
                    if (x + 1 < rows && !visited[x + 1][y]) {
                        x++;
                    } else {
                        dir = Dir.LEFT;
                        y--;
                    }
                    break;

                case LEFT:
                    if (y - 1 >= 0 && !visited[x][y - 1]) {
                        y--;
                    } else {
                        dir = Dir.UP;
                        x--;
                    }
                    break;

                case UP:
                    if (x - 1 >= 0 && !visited[x - 1][y]) {
                        x--;
                    } else {
                        dir = Dir.RIGHT;
                        y++;
                    }
                    break;
            }
        }
        return res;
    }
}
