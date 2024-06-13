// https://leetcode.com/problems/maximum-xor-for-each-query

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;
        
        int max = findMax(maximumBit);
        
        int all=0;
        for(int n : nums){
            all= all^n;
        }
        
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            
            int ed = len-i;
            if(ed==len){
                //xor nothing;
                
            }else{
                all = all^nums[ed];
            }
            
            int tempAll = all;
            int mb = maximumBit;
            int k=0;
            while(mb>0){
                
                k<<1;
                if(tempAll&1==1){
                    
                }else{
                    k+1
                }
                mb--;
            }
        }
        
        return res;
            
    }
    
    
    private int findMax(int mb){
        
        int res =1;
        while(mb>0){
            res = res<<1;
            mb--;
        }
        
        return res-1;
    }
}