// https://leetcode.com/problems/number-of-1-bits

/*int hammingWeight(uint32_t n) {
    int m=1,sum=0;
    for(int i=0;i<32;i++)
    {
        if((1 & n)!=0)
            sum++;
        m<<1;
    }
    return sum;
}

public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
        if ((n & mask) != 0) {
            bits++;
        }
        mask <<= 1;
    }
    return bits;
}
*/


//tricky
int hammingWeight(uint32_t n) {
    int res = 0;
    while( n )
    {
        n &= n - 1;
        res++;
    }
    return res;
}