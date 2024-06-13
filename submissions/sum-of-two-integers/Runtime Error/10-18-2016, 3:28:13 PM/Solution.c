// https://leetcode.com/problems/sum-of-two-integers

int getSum(int a, int b) {
    
    if (a&b == 0)
        return a|b;
    else
        return getSum(a^b, (a&b)<<1);
}


