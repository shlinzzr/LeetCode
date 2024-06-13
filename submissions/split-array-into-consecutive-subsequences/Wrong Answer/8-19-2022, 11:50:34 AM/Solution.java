// https://leetcode.com/problems/split-array-into-consecutive-subsequences

class Solution {
    public boolean isPossible(int[] nums) {
        boolean res = false;
        
        int cntA=1;
        int cntB=1;
        Integer curB = null;
        
        for(int i=1, curA=nums[0]; i<nums.length; i++){
            
            if(nums[i]==curA+1 || curB==null || nums[i]==curB+1 ){
                
                if(nums[i]==curA+1 && ( curB==null || nums[i]==curB+1)){
                    
                    if(cntA<=cntB){
                        cntA++;
                        curA = nums[i];
                    }else{
                        cntB++;
                        curB = nums[i];
                    }
                }else if(nums[i]==curA+1 ){
                    
                    cntA++;
                    curA = nums[i];
                    
                }else if(nums[i]==curB+1 ){
                    cntB++;
                    curB = nums[i];
                }
                
            }else{
                return false;
            }
        }
        
//[1,2,3,4,4,5]
// A B A B A B        
        
        return cntA>=3&&cntB>=3 ? true : false;
        
    }
}

