class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int n=nums.length;
        for (int i=0;i<n;i++){
            int diff = target-nums[i];
            if (map1.containsKey(diff)){
                return new int[]{map1.get(diff),i};
            }
            map1.put(nums[i],i);
        }
        return new int[]{};
        
    }
}
