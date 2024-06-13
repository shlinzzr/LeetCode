// https://leetcode.com/problems/convert-a-number-to-hexadecimal

char inttochar(int num)
{
    switch(num){
        case 0: return '0';
        case 1: return '1';
        case 2: return '2';
        case 3: return '3';
        case 4: return '4';
        case 5: return '5';
        case 6: return '6';
        case 7: return '7';
        case 8: return '8';
        case 9: return '9';
        case 10: return 'a';
        case 11: return 'b';
        case 12: return 'c';
        case 13: return 'd';
        case 14: return 'e';
        case 15: return 'f';
    }
    return '0';
}

char* revstr(char *p){
    int n = strlen(p);
    for(int i=0;i<n;i++)
    {
        p[i]   = p[i] ^ p[n-i];
        p[n-i] = p[i] ^ p[n-i];
        p[i]   = p[i] ^ p[n-i];
    }
    return p;
}


char* toHex(int num) {
    int i=0, j=0, mod=0,tmp=num, org= num;
    
    if(org < 0) //2's complement
    {
        num = -num - 1;
    }
    
    while(tmp){
        tmp=tmp/16;
        j++;
    }
    j--;
    //printf("%d",j);
    
    char *p= malloc(j*sizeof(char *));
    while(num){
        mod = num % 16;
        *(p+j-i) = inttochar(mod);
        i++;
        num = num / 16;
    }
     
     if(org < 0)
     {
         int n = strlen(p);
         for(int i=0;i<8;i++)
         {
             //p[i] = p[i]-'0';
             
             printf("%c ", p[i]+16);
             
             
         }
         
     }

    
    
    return p;
}