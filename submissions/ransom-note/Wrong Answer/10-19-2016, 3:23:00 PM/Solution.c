// https://leetcode.com/problems/ransom-note

bool canConstruct(char* ransomNote, char* magazine) {
    
    int rlen= strlen(ransomNote);
    int mlen= strlen(magazine);
    int count[26] = {0};
    
    /*

    // use pointer is more elegant!   //https://discuss.leetcode.com/topic/59921/c-6ms-solution/3
    while(*magazine){
        count[*magazine++ - 'a']++;
    }
    while(*ransomNote){
        if(--count[*ransomNote++ - 'a'] < 0)
              return false;
    }
    return true;
    
    */

  
    for(int i=0;i<rlen;i++)
    {
        count[ransomNote[i]-'a']++;
    }
    
    for(int j=0;j<mlen;j++)
    {
        count[magazine[j]-'a']++;
    }
    
    for(int i = 0; i < 26; i++)
        if(count[i] < 0 ) {
            printf("%d", count[i]);
            return false;
        }
    return true;
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    