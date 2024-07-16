sum is initialized to 0.
A loop runs from 0 to k-1 to calculate the sum of the first k elements of cardPoints. This is the initial sum when taking the first k cards from the beginning.
res is initialized to sum.
k is decremented by 1 to adjust for zero-based indexing in the upcoming while loop.
i is initialized to the last index of cardPoints.

While loop to update sum and res:

The loop continues until k is greater than or equal to 0.
In each iteration:
Update sum by subtracting the element at index k and adding the element at index i. This effectively moves one card from the beginning of the initial selection to the end of the array.
Decrement both k and i.
Update res to be the maximum of the current res and sum

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum =0;
        for (int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int res=sum;
        k--;
        int i = cardPoints.length-1;
        while (k>=0){
            sum = sum - cardPoints[k] + cardPoints[i];
            k--;
            i--;
            res = Math.max(res, sum);
        }
        return res;
        
    }
}
