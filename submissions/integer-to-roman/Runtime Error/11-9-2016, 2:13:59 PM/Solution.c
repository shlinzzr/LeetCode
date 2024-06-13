// https://leetcode.com/problems/integer-to-roman

char* cccc(char c , int nums )
{
    char* arr;
    for(int i=0; i<nums ; i++)
    {
        arr += c;
    }
    return arr;
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