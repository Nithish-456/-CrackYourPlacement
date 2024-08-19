class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b)-> (b.profit - a.profit));
        int max_deadline=0;
        for (Job j:arr){
            if (j.deadline>max_deadline){
                max_deadline = j.deadline;
            }
        }
        int[] slot = new int[max_deadline+1];
        Arrays.fill(slot, -1);
        int c=0;
        int profit=0;
        for(Job jo:arr){
            for (int j = jo.deadline;j>0;j--){
                if(slot[j]==-1){
                    slot[j]= jo.id;
                    c++;
                    profit+=jo.profit;
                    break;
                }
            }
        }
        return new int[]{c,profit};
    }
}
