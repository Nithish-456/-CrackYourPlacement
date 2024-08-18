public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        Queue<TreeNode> qu = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        qu.add(root);
        while (!qu.isEmpty()){
            TreeNode node = qu.poll();
            if (node == null){
                res.append("n ");
                continue;
            }
            res.append(node.val+" ");
            qu.add(node.left);
            qu.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> qu = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        qu.add(root);
        for (int i=1;i<values.length;i++){
            TreeNode parent = qu.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                qu.add(left);
            }
            if (!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                qu.add(right);
            }
        }
        return root;
        
    }
}
