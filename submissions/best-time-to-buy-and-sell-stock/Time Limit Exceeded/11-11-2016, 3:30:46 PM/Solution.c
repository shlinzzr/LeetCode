// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

int maxProfit(int* prices, int pricesSize) {
    int max=0,in=0,out=0;
    
    for(int i=0;i<pricesSize;i++)
    {
        for(int j=i+1;j<pricesSize;j++)
        {
            int profit = prices[j] - prices[i];
            if(profit>0 && profit >max)
            {
                max = profit;
                in  = i;
                out = j;
            }
        }
    }
    return max;
    
}