class Solution {
    private static class TrieNode {
        TrieNode[] children;
        int index;
        List<Integer> palindromePrefixRemaining;

        TrieNode() {
            children = new TrieNode[26];
            index = -1;
            palindromePrefixRemaining = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        // Build the trie
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        // Find palindrome pairs
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, result);
        }

        return result;
    }

    private void addWord(TrieNode root, String word, int index) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                node.palindromePrefixRemaining.add(index);
            }
            node = node.children[j];
        }
        node.index = index;
        node.palindromePrefixRemaining.add(index);
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> result) {
        TrieNode node = root;
        String word = words[i];
        for (int j = 0; j < word.length(); j++) {
            if (node.index >= 0 && node.index != i && isPalindrome(word, j, word.length() - 1)) {
                result.add(Arrays.asList(i, node.index));
            }
            node = node.children[word.charAt(j) - 'a'];
            if (node == null) return;
        }
        for (int j : node.palindromePrefixRemaining) {
            if (i != j) {
                result.add(Arrays.asList(i, j));
            }
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
}
