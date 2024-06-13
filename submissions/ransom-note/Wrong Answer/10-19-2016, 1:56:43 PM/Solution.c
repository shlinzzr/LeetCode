// https://leetcode.com/problems/ransom-note

bool canConstruct(char* ransomNote, char* magazine) {
    int mlen= strlen(magazine);
    int rlen= strlen(ransomNote);
    int k=0;
    for(int i=0;i<mlen;i++)
    {
        for(int j=0;j<rlen;j++)
        {
            if( magazine[i] != ransomNote[j])
            {
              break;
            }
            else{
                i+=1;
                k=j;
            }
                
                
            
            
            
            
        }
        if (k==mlen-1)
        return false;
    }
    return true;
}