// https://leetcode.com/problems/integer-to-roman

/*char* cccc(char c , int nums )
{
    char* arr;
    for(int i=0; i<nums ; i++)
    {
        arr[] += c;
    }
    return *arr;
}

char* intToRoman(int num) {
    int M = 1000;
    int D = 500;
    int C = 100;
    int L = 50;
    int X = 10;
    int V = 5;
    int I = 1;
    
    int mm = num/M;
    int dd = num%M/D;
    int cc = num%M%D/C;
    int ll = num%M%D%C/L;
    int xx = num%M%D%C%L/X;
    int vv = num%M%D%C%L%X/V;
    int ii = num%M%D%C%L%X%V;
    
    //char c* = 
    return cccc('M', mm);  //+dd*'D'+cc*'C'+ll*'L'+xx*'X'+vv*'V'+ii;
}
*/
char* intToRoman(int num) {
    char* chM[] = {"", "M", "MM", "MMM"};
    char* chC[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    char* chX[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    char* chI[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
    //return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    int step[] = {0,1,2,3,2,1,2,3,4,2};
    char *p = (char *)malloc(100);
    memset(p,0,100);//*****************why******************
    int i = 0;
    int mod = num/1000;


    for(int j=0;j<step[mod];j++)
    {
    	*(p+i)= *(chM[mod]+j);
    	i++;
    }
    
    mod = num/100%10;
    for(int j=0;j<step[mod];j++)
    {
    	*(p+i)= *(chC[mod]+j);
    	i++;
    }
    
    mod = num/10%10;
    for(int j=0;j<step[mod];j++)
    {
    	*(p+i)= *(chX[mod]+j);
    	i++;
    }
    
    mod = num%10;
    for(int j=0;j<step[mod];j++)
    {
    	*(p+i)= *(chI[mod]+j);
    	i++;
    }
    return p;
}


