// https://leetcode.com/problems/shortest-way-to-form-string

class Solution {
    public int shortestWay(String source , String target) {
     
        int len = source.length();
        
        
        int idx =0;
        for(int i=0; i<target.length(); i++){
            
            int cnt=0;
            while(source.charAt(idx%len)!=target.charAt(i)){
                idx++;
                cnt++;
                
                if(cnt>len)
                    return -1;
                    
                    
            }
            
            idx++;
        }
        
        return idx/len;
        
    }
}