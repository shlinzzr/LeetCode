// https://leetcode.com/problems/happy-number

int digitSquareSum(int n) {
    int sum = 0, tmp;
    while (n) {
        tmp = n % 10;
        sum += tmp * tmp;
        n /= 10;
    }
    return sum;
}

bool isHappy(int n) {
    int slow, fast;
    slow = fast = n;
    do {
        slow = digitSquareSum(slow);
        fast = digitSquareSum(fast);
        fast = digitSquareSum(fast);
    } while(slow != fast);
    if (slow == 1) return 1;
    else return 0;
}
/*int squareSum(int n)
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
        printf("%d\n", slow);
    }
    
    if (slow == 1) return 1;
    else return 0;

    
    
}*/