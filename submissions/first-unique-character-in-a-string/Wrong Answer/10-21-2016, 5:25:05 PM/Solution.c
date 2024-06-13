// https://leetcode.com/problems/first-unique-character-in-a-string

int firstUniqChar(char* s) {
    int n = strlen(s);
    int *arr = malloc(52*sizeof(int)); //a-z A-Z
    
    
    for(int i=0;i<n;i++)
    {
        int ai = *(s+i)-'a';
        int Ai = *(s+i)-'A';
        //printf("%d %d ", ai ,Ai);
        
        if( ai>=0&&ai<26 ) 
            arr[*(s+i)-'a'] = s[i];
        else if( Ai>=0&&Ai<26 ) 
            arr[*(s+i)-'A'+26] = s[i];
    }

    for(int i=0;i<n;i++)
    {
        int ai = *(s+i)-'a';
        int Ai = *(s+i)-'A';
        
        if( ai>=0&&ai<26 ) 
            if(arr[*(s+i)-'a'] = 0) 
                return i;
        else if(Ai>=0&&Ai<26) 
                 if(arr[*(s+i)-'A'] = 0) 
                     return i;
      
    }
    
    return -1;
}