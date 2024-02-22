// https://leetcode.com/problems/ugly-number

bool isUgly(int num) {
    if (num==1) return true;
    if (num==0) return false;
    while(num!=1)
    {
        if(num%2==0 || num%3==0 || num%5==0)
        {
            if(num%2==0) num/=2;
            if(num%3==0) num/=3;
            if(num%5==0) num/=5;
        }
        else if(num!=1)
            return false;
    }
    return true;
}

/* 有點神
for (int i=2; i<6 && num; i++)
    while (num % i == 0)
        num /= i;
return num == 1;
*/