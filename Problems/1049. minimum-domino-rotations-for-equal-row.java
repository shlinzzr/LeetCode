// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int len = tops.length;
        int[] arr = new int[7];
        
        int target = -1;
        boolean find=true;
        for(int i=0; i<len; i++){
            
            if(arr[tops[i]]<i && arr[bottoms[i]]<i){
                find=false;
                break;
            }
            
            
            if(arr[tops[i]]>=i)
                target = tops[i];
            else 
                target = bottoms[i];
            
            
            arr[tops[i]]++;
            arr[bottoms[i]]++;
            
            
        }
         if(find==false){
                return -1;
        }
        
        
        return Math.min(helper(tops, target), helper(bottoms, target));
        
    }
    
    
    public int helper(int[] tops, int target) {
        int len =tops.length;
        int cnt=0;
        for(int i=0; i<len; i++){
            if(tops[i]!=target){
                cnt++;
            }
        }
        return cnt;
    }
    
    
    
}