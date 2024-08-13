class Solution {
    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];
        HashMap<Integer, List<Integer>> row = new HashMap<>(); // for same rows
        HashMap<Integer, List<Integer>> col = new HashMap<>(); // for same cols
        for (int i = 0; i < stones.length; i++){
            row.computeIfAbsent(stones[i][0], o -> new ArrayList<>()).add(i); // rowMap = { 0: [[0, 0]] } like wise
            col.computeIfAbsent(stones[i][1], o -> new ArrayList<>()).add(i); 
        }
        int rstones= 0;
        for (int i = 0; i < stones.length; i++)
            if (!visited[i]){
                removest(visited, stones, i, row, col);
                rstones++;
            }
        return stones.length - rstones;
    }

    private void removest(boolean[] visited, int[][] stones, int idx,
            Map<Integer, List<Integer>> row, Map<Integer, List<Integer>> col){
        if (visited[idx]) return; // base case
        visited[idx] = true; // mark as visited.
        int r = stones[idx][0];
        int c = stones[idx][1];
        for (int index : row.get(r)) // not null because the current stone is in it
            removest(visited, stones, index, row, col); // visit all the stones on this row

        for (int index : col.get(c))
            removest(visited, stones, index, row, col); // visit all the stones on this col
    }
}
