class Solution {
    private List<Set<Integer>> tree;
    private int[] count;
    private int[] answer;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        count = new int[n];
        answer = new int[n];
        dfs1(0, -1);
        dfs2(0, -1);
        return answer;
    }
    private void dfs1(int node, int parent) {
        count[node] = 1;
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs1(child, node);
                count[node] += count[child];
                answer[node] += answer[child] + count[child];
            }
        }
    }
    private void dfs2(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child != parent) {
                answer[child] = answer[node] - count[child] + (tree.size() - count[child]);
                dfs2(child, node);
            }
        }
    }
}
