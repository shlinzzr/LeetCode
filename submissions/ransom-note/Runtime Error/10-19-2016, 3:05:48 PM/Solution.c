// https://leetcode.com/problems/ransom-note

bool canConstruct(char* ransomNote, char* magazine) {
    
    int rlen= strlen(ransomNote);
    int mlen= strlen(magazine);
    int count[26] = {0};
    
    for(int i=0;i<rlen;i++)
    {
        count[magazine[i]-'a']++;
    }
     for(int j=0;j<mlen;j++)
     {
          count[ransomNote[j]-'a']--;
     }
    
    if(count<0)
    return false;
    
    return true;
}
    
    
    
    
    
    
    
    
    
    
    
    
    
//    int mlen= strlen(magazine);
//    int rlen= strlen(ransomNote);
//    bool matched = false;
//    for(int mag_idx=0; mag_idx<mlen; mag_idx++)
//    {
//        for(int ran_idx=0; ran_idx<rlen; ran_idx++)
//        {
//            if(magazine[mag_idx] != ransomNote[ran_idx]){
//               break;
//            }                
//            else{                
//                char* substr;             
//                strncpy(substr, magazine + mag_idx, rlen);
//                printf("%d", substr);
//                
//                matched = mapped(ransomNote, substr);                  
//            }
//        }
//    }
//    return matched;
//}
//
//
//bool mapped(char* r, char* m){
//    n= strlen(r);
//    for(int i=0;i<n;i++)
//    {
//        if(r[i]!=m[i])
//        return false;
//        
//    }
//    return true;

