class Solution
{
    int tour(int petrol[], int distance[])
    {
	    int start = 0;
	    int def = 0; // deficit encountered when the truck fails to reach the next pump.
	    int balance = 0; //current balance of petrol in the truck.
	    for (int i = 0; i < petrol.length; i++) {
            balance += petrol[i] - distance[i];
            //If the balance becomes negative, 
            // it means the truck cannot reach the next pump from the current starting point.
            if (balance < 0) {
                //  update the starting point to the next pump (i + 1) and add the current balance to the deficit. 
                start = i + 1;
                def += balance;
                balance = 0; // reset 
            }
        }
        if (balance + def >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
