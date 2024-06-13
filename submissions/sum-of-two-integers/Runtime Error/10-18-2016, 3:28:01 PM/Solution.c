// https://leetcode.com/problems/sum-of-two-integers

int getSum(int a, int b) {
    
    if (a&b == 0)
        return a|b;
    else
        return getSum(a^b, (a&b)<<1);
}



int lenHelper(unsigned x) {
    if(x>=1000000000) return 10;
    if(x>=100000000) return 9;
    if(x>=10000000) return 8;
    if(x>=1000000) return 7;
    if(x>=100000) return 6;
    if(x>=10000) return 5;
    if(x>=1000) return 4;
    if(x>=100) return 3;
    if(x>=10) return 2;
    return 1;
}