class Solution{
 public int moves(int[] nums){
  Arrays.sort(nums);
  int c=0;
  int med = nums[nums.length/2];
  for (int i:nums){
    c+=Math.abs(med - i);
  return c;
  }
}}
