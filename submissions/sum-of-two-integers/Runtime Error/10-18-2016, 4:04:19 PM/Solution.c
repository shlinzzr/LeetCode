// https://leetcode.com/problems/sum-of-two-integers

/*
int getSum(int a, int b) {
    int c;
    while ((c=a & b)!= 0) {
        a = a ^ b;
        b = c << 1;
    }
    return a ^ b;
}
*/


  
int getSum(int a, int b) {
    if (a&b == 0)
        return a^b;
    else
        return getSum(a^b, ((a&b)<<1));
}

