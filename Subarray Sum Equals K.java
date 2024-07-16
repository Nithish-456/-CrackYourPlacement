class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0, res =0;
        Map<Integer, Integer> presum = new HashMap<>(); //hash map (prefix_sum_count) to store the frequency of each prefix sum encountered so far.
        presum.put(0,1); //Intialised with 0 presum with frequency 1
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (presum.containsKey(sum-k)){ //For each prefix sum, check if the difference between the current prefix sum and k is in the hash map.
                res+=presum.get(sum-k);
            }
            presum.put(sum, presum.getOrDefault(sum,0)+1); //Update the hash map with the current prefix sum frequency.
        }
        return res;   
    }
}
