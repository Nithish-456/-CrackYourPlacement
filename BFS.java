class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> qu = new LinkedList<>();
        visited[0]=true;
        qu.add(0);
        while(!qu.isEmpty()){
            int node = qu.poll();
            bfs.add(node);
            for (int nei:adj.get(node)){
                if(!visited[nei]){
                    visited[nei]=true;
                    qu.add(nei);
                }
            }
        }
        return bfs;
    }
}
