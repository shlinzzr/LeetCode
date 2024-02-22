// https://leetcode.com/problems/convert-a-number-to-hexadecimal

//https://discuss.leetcode.com/topic/62367/share-my-c-solution
char* toHex(int num) {
    unsigned int n = num;
    int size = 0;
    if (n==0) return "0";
    
    //printf("n=%d", n);
    
    
    while(n>0){
        printf("n=%d ", n);
        n/=16;
        size++;
    }
    n=num;
    
    char* ans = (char*) malloc(sizeof(char*)*size);
    ans[size]='\0';
    while(n>0){
        char c = n%16;
        //printf("n=%d c=%d %d\n", n, c, -2/16);
        (c<10) ? (c+='0') : (c+='a'-10);
        n=n/16;
        ans[--size] = c;
    }
    return ans;
}

 //幹...寫不出來ＱＡＱ runtime error
 /*
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
    
    //if (num==0) return '0';
    
    if(org < 0) //2's complement
    {
        num = -num - 1;
    }
    
    if(org<0)
        j=8;
    else
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
    
     for(int i=0;i<strlen(p);i++) //print p
     {
         printf("%c ", *(p+i));
     }
     //printf("%d ", '9'-'0');
     
     if(org < 0)
     {
         int n = strlen(p);
         for(int i=0;i<8;i++)
         {
             if(p[i]>=97 && p[i]<=102) //a-f
                 p[i] ='f'- p[i] ; 
             else if(p[i]>=48 && p[i]<=57) //0-9
                { 
                 p[i] = p[i] - 48 ;  //real int value
                 if(16-p[i]>9)
                    p[i] = 16-p[i]-10+96;     // 16 - 1  - 10     + 96
                 else                     //base- ex - 'a' + 'a'base
                    p[i] = 16-p[i];
                }
             else 
                 p[i] ='f';
             //printf("i=%d, p=%d\n", i, p[i]);
         }
     }
     
     if(org==0){
         char *p= malloc(sizeof(char*));
         p = "0";
         //printf("%c", p);
         return p;
     }
    return p;
}*/