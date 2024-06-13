// https://leetcode.com/problems/reverse-string

/*char* reverseString(char* s) {
    int len = strlen(s);
    //char * result = malloc((strlen(s)+1)*sizeof(char));
    char *arr     = malloc(len*sizeof(char));
    
    for(int i=0, j=len-i; i<len; i++)
    {
           

    }
}*/

char* reverseString(char* s) {
    
    int len=strlen(s);
    
   // printf(len);
    
    char arr[len];
    int i ;
    for(i=0;i<len;i++){
        arr[len-i-1] = *(s+i);
    }
    //arr[i]='\0';
    strcpy(s,arr);
    return s;
}