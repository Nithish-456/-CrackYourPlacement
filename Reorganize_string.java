class Solution {
    public String reorganizeString(String s) {
        // Create a frequency map of the characters
        Map<Character, Integer> fmap = new HashMap<>();
        for (char c : s.toCharArray()) {
            fmap.put(c, fmap.getOrDefault(c, 0) + 1);
        }       
        // Create a max heap (priority queue) based on character frequency
        PriorityQueue<Character> max_heap = new PriorityQueue<>((a, b) -> fmap.get(b) - fmap.get(a));
        max_heap.addAll(fmap.keySet());       
        // Build the result string
        StringBuilder res = new StringBuilder();       
        // Previous character and its frequency
        char prev_char = '#';
        int prev_freq = 0;       
        while (!max_heap.isEmpty()) {
            char curr_char = max_heap.poll();
            res.append(curr_char);
            fmap.put(curr_char, fmap.get(curr_char) - 1);           
            // Add the previous character back to the heap if its frequency > 0
            if (prev_freq > 0) {
                max_heap.offer(prev_char);
            }            
            // Update previous character and its frequency
            prev_char = curr_char;
            prev_freq = fmap.get(curr_char);
        }       
        // If the resulting string's length is not equal to the original string's length, return ""
        if (res.length() != s.length()) {
            return "";
        }        
        return res.toString();        
    }
}
