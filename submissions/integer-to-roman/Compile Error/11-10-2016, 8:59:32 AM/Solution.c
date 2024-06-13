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
    char* M[] = {"", "M", "MM", "MMM"};
    char* C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    char* X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    char* I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    char *p = malloc(100*sizeof(char*));
    
    *p = set( M[num/1000],       *p, 0);
    *p = set( C[(num%1000)/100], *p, strlen(M[num/1000]));
    *p = set( X[(num%100)/10],   *p, strlen(C[(num%1000)/100]));
    *p = set( I[num%10],         *p, strlen(X[(num%100)/10]));
    
    return *p;
}

char* set(char *c, char *p, int idx){
    n = strlen(c);
    for(int i=0; i<n; i++;)
    {
        p[idx+i] = c[i];
    }
    return *p;
    
}
