def minCost(coin, n, k): 
coin.sort() 
  
coins_needed = math.ceil(1.0 * n //
                            (k + 1)); 
  
    # calculate sum of all 
    # selected coins 
    ans = 0
    for i in range(coins_needed - 1 + 1):  
        ans += coin[i] 
      
    return ans 
      
