class Trie {
    private TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        TrieNode() {
            children = new TrieNode[26]; 
            isEndOfWord = false;
        }
    }

    public Trie() {
        root = new TrieNode(); 
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create a new node if doesn't exist
            }
            node = node.children[index];
        }
        node.isEndOfWord = true; // Mark the end of the word
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord; // Check if it's the end of a word
    }
    
    // Checks if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null; // Just check if the prefix exists
    }
    
    // Helper method to search for a prefix in the Trie
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null; // If node doesn't exist, return null
            }
            node = node.children[index];
        }
        return node; // Return the node where the word/prefix ends
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
