class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // Using  a set to track seen frequencies
        Set<Integer> seenFreqs = new HashSet<>();
        int del = 0;
        for (int freq : freqMap.values()) {
            while (freq > 0 && !seenFreqs.add(freq)) {
                freq--; 
                del++; 
            }
        }
        return del;
    }
}
