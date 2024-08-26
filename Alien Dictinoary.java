

// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Step 1: Create a graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build the graph by comparing adjacent words
        for (int i = 0; i < n - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Step 3: Perform topological sort using Kahn's algorithm (BFS)
        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int v : adj.get(i)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.append((char) (u + 'a'));

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // If all characters are included in the order, return it; otherwise, return an empty string
        if (order.length() == k) {
            return order.toString();
        } else {
            return "";  // In case of a cycle or other issues, though problem constraints ensure a valid order exists
        }
    }
}
