// https://leetcode.com/problems/first-unique-character-in-a-string

int firstUniqChar(char* s) {
    int n = strlen(s);
    int *arr = malloc(52*sizeof(int)); //a-z A-Z
    
    
    for(int i=0;i<n;i++)
    {
        int ai = *(s+i)-'a';
        int Ai = *(s+i)-'A';
        
        if( ai>=0&&ai<26 ) 
            arr[ai]++;
        else if( Ai>=0&&Ai<26 ) 
            arr[Ai+26]++;
    }
    
   // for(int i=0;i<52;i++)
   //{
   //    printf("%d ", arr[i]);
   //}
    
    for(int i=0;i<n;i++)
    {
        int ai = *(s+i)-'a';
        int Ai = *(s+i)-'A';
        
        if( ai>=0 && ai<26 ) {
            //printf("\n%d %d", arr[ai] ,ai);
            if(arr[ai] == 1)  return i;
        }
        else if( Ai>=0 && Ai<26 ) {
            //printf("\n%d %d", arr[Ai] ,Ai);
            if(arr[Ai + 26] == 1)  return i;
        }
      
    }
    
    return -1;
}