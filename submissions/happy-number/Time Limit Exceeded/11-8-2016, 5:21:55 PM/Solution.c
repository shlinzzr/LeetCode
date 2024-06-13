// https://leetcode.com/problems/happy-number

int squareSum(int n)
{
    int tmp=0, sum=0;
    while(n)
    {
        tmp = n %10;
        sum += tmp * tmp;
        n = n / 10;
    }
    return sum;
}

bool isHappy(int n) {
    
    while(n!=1)
    {
        n = squareSum(n);
    }
    
    return true;
    
    
}