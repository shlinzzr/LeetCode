// https://leetcode.com/problems/ransom-note

bool canConstruct(char* ransomNote, char* magazine) {
    
    int rlen= strlen(ransomNote);
    int mlen= strlen(magazine);
    int count[26] = {0};
    
    

/*
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
        count[magazine[i]-'a']++;
    }
     for(int j=0;j<mlen;j++)
     {
         if( count[ransomNote[j]-'a']--<0)
             return false;
     }
   
    return true;
}
    
    
    
    
    
    
    
    
    
    
    