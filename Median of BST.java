class Tree
{
    public static float findMedian(Node root)
    {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int n = res.size();
        if (n%2==1){
            return res.get(n/2);
        }
        else{
            return (res.get(n/2-1)+res.get(n/2))/2.0f;
        }
    }
    private static void inorder(Node root, List<Integer> res){
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.data);
        inorder(root.right, res);
    }
}
