// https://leetcode.com/problems/ransom-note

bool canConstruct(char* ransomNote, char* magazine) {
    int rlen= strlen(ransomNote);
    int mlen= strlen(magazine);
    int k=0;
    for(int i=0;i<rlen;i++)
    {
        for(int j=k;j<mlen;j++)
        {
            if( ransomNote[i] == magazine[j] )
            {
                k=j;
              break;
            }
                
            
            
            
            
        }
        if (k==mlen-1)
        return false;
    }
    return true;
}