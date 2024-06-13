// https://leetcode.com/problems/number-of-1-bits

int hammingWeight(uint32_t n) {
    int m=1,sum=0;
    for(int i=0;i<n;i++)
    {
        if(1 & n)
            sum++;
        else 
            n<<1;
    }
    return sum;
}