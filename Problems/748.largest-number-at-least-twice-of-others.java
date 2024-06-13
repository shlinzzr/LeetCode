// https://leetcode.com/problems/largest-number-at-least-twice-of-others

class Solution {
    public int dominantIndex(int[] nums) {
        int top1 =0;
        int top2 = 0;
        int i1= 0, i2=0;
        int len = nums.length;
        
        
        for(int i=0; i<len; i++){
            int n = nums[i];
            if(n>top1){
                i2=i1;
                i1=i;
                top2=top1;
                top1= n;
                
            }else if(n>top2){
                i2=i;
                top2 = n;
            }
        }
        
        return top1>=2*top2 ? i1 : -1;
         
    }
}