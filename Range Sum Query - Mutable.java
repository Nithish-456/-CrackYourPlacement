class NumArray {
    private int[] segmentTree;
    private int n;

    // Constructor to build the segment tree
    public NumArray(int[] nums) {
        n = nums.length;
        if (n > 0) {
            segmentTree = new int[2 * n];
            buildSegmentTree(nums);
        }
    }

    // Build the segment tree from the given array
    private void buildSegmentTree(int[] nums) {
        // Copy the original array into the second half of the segment tree
        for (int i = 0; i < n; i++) {
            segmentTree[i + n] = nums[i];
        }
        // Build the segment tree by calculating parents
        for (int i = n - 1; i > 0; --i) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
        }
    }

    // Update the value at index `i` to `val` and update the segment tree
    public void update(int index, int val) {
        // Update the value at the corresponding leaf node
        index += n;
        segmentTree[index] = val;

        // Update the parent nodes
        for (int i = index; i > 1; i /= 2) {
            segmentTree[i / 2] = segmentTree[i] + segmentTree[i ^ 1]; // i^1 gets the sibling
        }
    }

    // Query the sum of elements between indices left and right inclusive
    public int sumRange(int left, int right) {
        int sum = 0;
        // Shift the indices to point to the leaves of the segment tree
        left += n;
        right += n;

        // Traverse the tree from the leaves towards the root
        while (left <= right) {
            // If left is a right child, add its value and move to the next subtree
            if ((left % 2) == 1) {
                sum += segmentTree[left];
                left++;
            }
            // If right is a left child, add its value and move to the previous subtree
            if ((right % 2) == 0) {
                sum += segmentTree[right];
                right--;
            }
            // Move to the parent nodes
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}
