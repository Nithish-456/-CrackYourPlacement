class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0; // if there is no end word in the wordslist        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);        
        int steps = 1;       
        while (!queue.isEmpty()) {
            int level_size = queue.size();          
            for (int i = 0; i < level_size; i++) {
                String curr_word = queue.poll();               
                // Try all possible one-letter transformations
                char[] word_chars = curr_word.toCharArray();               
                for (int j = 0; j < word_chars.length; j++) {
                    char org = word_chars[j];                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == org) continue;                       
                        word_chars[j] = c;
                        String newWord = new String(word_chars);                        
                        // If we found the endWord, return the result
                        if (newWord.equals(endWord)) return steps + 1;                       
                        // If the new word is in the wordSet, add it to the queue
                        if (words.contains(newWord)) {
                            queue.offer(newWord);
                            words.remove(newWord);  // Remove to prevent revisiting
                        }
                    }                    
                    word_chars[j] = org;  // Revert back to the original word
                }
            }            
            steps++;
        }
        
        return 0;
    }
}
