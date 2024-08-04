class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p=new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            if(p.size()<k){
                p.add(nums[i]);
            }else if(p.peek()<nums[i]){
                p.remove();
                p.add(nums[i]);
            }
        }
        return p.peek();
           
    }
}
