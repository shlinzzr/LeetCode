// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks

class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        if(blocks.length()<k)
            return 0;
        
        
        int min=k;
        int w=0;
        int b=0;
        
        
        int st=0;
        
        for(int ed=0; ed<blocks.length();ed++){
            
            if(blocks.charAt(ed)=='W')
                    w++;
            else{
                b++;
            }
            
            if(ed-st+1<k){
                continue;    
            }
            
            min = Math.min(min, w);
            if(ed-st+1==k){
                
                if(blocks.charAt(st)=='W'){
                    w--;
                }else{
                    b--;
                }
                st++;
            }
        }
        
        return min;
        
    }
}