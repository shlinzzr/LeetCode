// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        
        int st =0, ed=nums.length-1;
        int head = nums[st], tail=nums[ed];
        while(st<ed){
            
            if(head==tail && ed-st==2)
                return ed-1;
            
            
            if(head>tail){
                
                ed--;
                tail += nums[ed];
            }else{
                st++;
                head += nums[st];
            }
        }
        
        if(head==tail)
            return st;
        else
            return -1;
        
    }
}