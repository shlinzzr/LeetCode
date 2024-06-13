// https://leetcode.com/problems/utf-8-validation

class Solution {
    public boolean validUtf8(int[] data) {
        
        int len = data.length;
        
        for(int i=0; i<len; i++){
            
            // check number of byte
            int d = data[i];
            
            int cnt= 0 ;
            for(int offset = 7; offset>=0; offset--){
                if( (1&(d>>offset)) ==0)
                    break;
                cnt++;
            }
            
            int j=i+1;
            while(j<cnt-1){
                
                if(j>=len)
                    return false;
                
                int dj = data[j];
                if( (1& (dj>>7))!=1 || (1&(dj>>6))!=1)
                    return false;
                j++;
            }
            
            
            i=j-1;
        }
        
        return true;
    }
}