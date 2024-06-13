// https://leetcode.com/problems/semi-ordered-permutation

class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int len = nums.length;
        
        int op=0;
        
        if(nums[0]==1 && nums[len-1]==len )
            return op;
        
        boolean flag = false;
        
        for(int i=0; i<len; i++){
            
            if(nums[i]==1){
                op+=i;
                flag = true;
            }
                
            
            if(nums[i]==len){
                
                op+=len-i-1;
                if(!flag)
                    op-=1;
            }
            
            
        }
        return op;
    }
}