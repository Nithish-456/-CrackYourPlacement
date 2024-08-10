class Solution {
    static int minDiff;
    static int[] finalSubset;

    public static ArrayList<ArrayList<Integer>> minDifference(int n, int[] arr) {
        minDiff = Integer.MAX_VALUE;
        finalSubset = new int[n];
        int totalSum = Arrays.stream(arr).sum();
        findMinRec(arr, n, 0, 0, 0, totalSum, new int[n]);
        // Calculate sums of the subsets
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            if (finalSubset[i] == 1) {
                sum1 += arr[i];
            }
        }
        int sum2 = totalSum - sum1;
        // Create result list with sums in increasing order
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Collections.singletonList(Math.min(sum1, sum2))));
        result.add(new ArrayList<>(Collections.singletonList(Math.max(sum1, sum2))));

        return result;
    }

    static void findMinRec(int[] arr, int n, int currIndex, int count, int currSum, int totalSum, int[] subset) {
        if (currIndex == n) {
            if ((n % 2 == 0 && count == n/2) || (n % 2 != 0 && (count == n/2 || count == n/2 + 1))) {
                int diff = Math.abs(totalSum - 2 * currSum);
                if (diff < minDiff) {
                    minDiff = diff;
                    finalSubset = Arrays.copyOf(subset, n);
                }
            }
            return;
        }
        // Include current element in subset1
        subset[currIndex] = 1;
        findMinRec(arr, n, currIndex + 1, count + 1, currSum + arr[currIndex], totalSum, subset);
        // Exclude current element from subset1
        subset[currIndex] = 0;
        findMinRec(arr, n, currIndex + 1, count, currSum, totalSum, subset);
    }
}
