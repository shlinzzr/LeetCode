// https://leetcode.com/problems/integer-to-roman



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
    
    return "XX";//''mm*'M'+dd*'D'+cc*'C'+ll*'L'+xx*'X'+vv*'V'+ii;
    
    
}