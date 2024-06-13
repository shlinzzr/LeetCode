// https://leetcode.com/problems/arranging-coins

int arrangeCoins(int n) {
    int i=0;
    for(i=1;n>=0;i++)
    {
        printf("%d %d\n",n,i);
        n=n-i;
        
    }
    
    return i-2;
}