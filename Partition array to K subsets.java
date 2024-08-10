class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	    if (k==1) return true;
	    if (n<k) return false;
	    
	    int sum=0;
	    for (int num:a) sum+=num;
	    
	    if(sum%k!=0) return false;
	    int subset_sum = sum/k;
	    boolean[] visited = new boolean[n];
	    return par(0,a,visited,k,0,0,subset_sum);
    }
    
    private boolean par(int start_idx, int[] a, boolean[] visited, int k, int curr_sum,int curr_num, int subset_sum){
        if (k==1) return true;
        
        if (curr_sum==subset_sum&& curr_num>0){
            return par(0,a,visited, k-1, 0,0,subset_sum);
        }
        for (int i = start_idx; i < a.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                if (par(i + 1, a, visited, k, curr_sum + a[i], curr_num + 1, subset_sum)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
