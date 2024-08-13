class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums,0,nums.length-1);      
    }
    public TreeNode bst(int[] nums,int s,int l){
        if(s>l){
            return null;
        }
        int mid=(s+l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=bst(nums,s,mid-1);
        root.right=bst(nums,mid+1,l);
        return root;
    }
}
