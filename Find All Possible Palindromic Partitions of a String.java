class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> currentList = new ArrayList<>();
        backtrack(S, 0, currentList, result);
        return result;
    }
    static void backtrack(String S, int start, ArrayList<String> currentList, ArrayList<ArrayList<String>> result) {
        if (start >= S.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int end = start; end < S.length(); end++) {
            if (isPalindrome(S, start, end)) {
                currentList.add(S.substring(start, end + 1));
                backtrack(S, end + 1, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    static boolean isPalindrome(String S, int start, int end) {
        while (start < end) {
            if (S.charAt(start) != S.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
};
