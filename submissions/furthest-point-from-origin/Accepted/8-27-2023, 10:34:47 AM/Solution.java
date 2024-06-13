// https://leetcode.com/problems/furthest-point-from-origin

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0, right=0, mid=0;
        
        for(char ch : moves.toCharArray()){
            
            if(ch=='L'){
                left++;
            }else if(ch=='R')
                right++;
            else
                mid++;
            
        }
        
        return left>right? left+mid-right : right-left+mid;
        
    }
}