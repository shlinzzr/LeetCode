// https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k

class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int a=0,n=nums.length;
        for(int i=0; i<n; i++)
        {
            int c=1;
            for(int j=i;j<n && c<=k;j++)
            {
                c=lcm(c, nums[j]);
                a+=(c==k)?1:0;
            }
        }
        return a;
    }
    public int gcd(int a, int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public int lcm(int a, int b)
    {
        return (a*b)/gcd(a,b);
    }
}