// https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid

class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] ini = new int[]{startPos[0], startPos[1]};
        
        
        int[] res = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            
            String steps = s.substring(i, s.length());
            int cnt = 0;
            
            startPos[0] = ini[0];
            startPos[1] = ini[1];
            
            for(int j=0; j<steps.length(); j++){
                char c = steps.charAt(j);
                
                int y = startPos[0];
                int x = startPos[1];
                
                
                if(c=='R' && x+1<n){
                    startPos[1] +=1;
                    
                }else if(c=='L' && x-1>=0){
                
                    startPos[1] -=1;
                    
                }else if(c=='U' && y-1>=0){
                    startPos[0] -=1;
                    
                }else if(c=='D' && y+1<n){
                
                    startPos[0] +=1;
                }else{
                    break;
                }
                cnt++;
            }
            
            res[i] = cnt;
            
            
            
        }
        return res;
        
    }
}