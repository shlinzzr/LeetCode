// https://leetcode.com/problems/ransom-note

bool canConstruct(char* ransomNote, char* magazine) {
    int mlen= strlen(magazine);
    int rlen= strlen(ransomNote);
    bool matched = false;
    for(int mag_idx=0; mag_idx<mlen; mag_idx++)
    {
        for(int ran_idx=0; ran_idx<rlen; ran_idx++)
        {
            if(magazine[mag_idx] != ransomNote[ran_idx]){
               break;
            }
                
            else{
                
                char* substr;
                strncpy(substr, magazine+mag_idx, rlen);
                printf("%d", substr);
                
                bool test = mappiing(ransomNote, substr);
                
                
                
                if (test == true)
                    return matched = true;
                
            }
        }
    }
    return matched;
}


bool mappiing(char* r, char* m){
    n= strlen(r);
    for(int i=0;i<n;i++)
    {
        if(r[i]!=m[i])
        return false;
        
    }
    return true;
}
