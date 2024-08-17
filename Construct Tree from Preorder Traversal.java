class Solution{
    int idx=0;
    Node constructTree(int n, int pre[], char preLN[]){
        if (n==0) return null;
        return helper(pre,preLN,n);
    }
    private Node helper(int pre[], char preLN[], int n) {
        // If all elements are processed, return null
        if (idx == n) {
            return null;
        }
        Node node = new Node(pre[idx]);
        char type = preLN[idx];
        idx++;
        if (type == 'N') {
            node.left = helper(pre, preLN, n);
            node.right = helper(pre, preLN, n);
        }
        return node;
    }
}
