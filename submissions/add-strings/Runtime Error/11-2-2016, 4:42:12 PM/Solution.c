// https://leetcode.com/problems/add-strings

char* addStrings(char* num1, char* num2) {
    int m = strlen(num1);
    int n = strlen(num2);
    
    
    int sum = 0;
    int sss = 0;
    for(int i=0;i<m;i++)
    {
        for(int j=1;j<i;j++)
            sss = sss *10;
       
        sum  += sss * (num1[i]-'0');
        
        
    }
    
    sss = 0;
    for(int i=0;i<n;i++)
    {
        for(int j=1;j<i;j++)
            sss = sss *10;
            
        sum  += sss * (num2[i]-'0');    
    }
   
   
   printf("%d ", sum);
    return '0';
    //return  num1-'0' +  num2-'0';
}