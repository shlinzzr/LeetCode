// https://leetcode.com/problems/utf-8-validation

class Solution {
    public boolean validUtf8(int[] data) {
        
        int len = data.length;
        
        for(int i=0; i<len; i++){
            
            // check number of byte
            int d = data[i];
            // System.out.println(Integer.toBinaryString(d));
                
            
            int cnt= 0 ;
            for(int offset = 7; offset>=0; offset--){
                if( (1&(d>>offset)) ==0)
                    break;
                cnt++;
            }
            
            if(cnt==1) 
                return false;
            
            // System.out.println("cnt="+cnt);
            
            int j=i+1;
            while(j<i+cnt){
                
                if(j>=len)
                    return false;
                
                int dj = data[j];
                
                // System.out.println(Integer.toBinaryString(dj));
                // System.out.println((dj>>6)==0b10);
                
                if( (dj>>6)!=0b10 )
                    return false;
                
                j++;
            }
            
            
            i=j-1;
        }
        
        return true;
    }
}