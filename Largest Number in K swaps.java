class Solution
{
    private static void findMaximumNumUtil(char[] str, int k, int index, StringBuilder maxNum) {
        if (k == 0 || index == str.length) {
            return;
        }

        char maxChar = str[index];
        for (int i = index + 1; i < str.length; i++) {
            if (str[i] > maxChar) {
                maxChar = str[i];
            }
        }
        if (maxChar != str[index]) {
            k--;
        }

        for (int i = index; i < str.length; i++) {
            if (str[i] == maxChar) {
                swap(str, index, i);
                String currentNum = new String(str);
                if (currentNum.compareTo(maxNum.toString()) > 0) {
                    maxNum.setLength(0);
                    maxNum.append(currentNum);
                }
                findMaximumNumUtil(str, k, index + 1, maxNum);
                swap(str, index, i);  // backtrack
            }
        }
    }
    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public static String findMaximumNum(String str, int k)
        {
            StringBuilder maxNum = new StringBuilder(str);
            findMaximumNumUtil(str.toCharArray(), k, 0, maxNum);
            return maxNum.toString();
        }
}
