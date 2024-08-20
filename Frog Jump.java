class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        // HashMap to keep track of each stone's possible jump sizes
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        // Initialize the first stone with jump size 0
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(stones[0]).add(0);
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int jump : dp.get(stone)) {
                // Try k - 1, k, k + 1 jumps
                for (int k = jump - 1; k <= jump + 1; k++) {
                    if (k > 0 && dp.containsKey(stone + k)) {
                        dp.get(stone + k).add(k);
                    }
                }
            }
        }
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
