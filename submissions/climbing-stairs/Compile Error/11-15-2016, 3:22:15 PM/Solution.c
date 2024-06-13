// https://leetcode.com/problems/climbing-stairs

int climbStairs(int n) {
    if(n<=3) return n;
    
    int a=1,b=1,res=0;
    for(int i=0; i<n; i++)
    {
        res=a+b;
        a=b
        b=res;
    }
    return res;
}