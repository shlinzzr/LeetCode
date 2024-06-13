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
    
    int slow = n, fast = n;
    while(slow != fast)
    {
        slow = squareSum(slow);
        fast = squareSum(squareSum(fast));
        //fast = squareSum(fast);
    }
    
    if (slow == 1) return 1;
    else return 0;

    
    
}