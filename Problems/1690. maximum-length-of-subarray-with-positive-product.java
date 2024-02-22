// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product

class Solution {
    
    // huifeng我大哥。https://www.youtube.com/watch?v=9WE8uAtdJGk
    
    public int getMaxLen(int[] nums) {
        
        int res = 0;
        
        for(int i=0; i<nums.length;i++){
            
            if(nums[i]==0) continue; // split by 0
            
            int j=i;
            int negCnt =0;
            int k=-1; // the first neg
            
            while(j<nums.length && nums[j]!=0){
                
                if(nums[j]<0)
                    negCnt++;
                
                if(negCnt%2==0){
                    res = Math.max(res , j-i+1);
                }else if(k!=-1){
                    res = Math.max(res, j-k);
                }
                
                if(k==-1 && nums[j]<0)
                    k = j;
                
                j++;
                
            }
            i=j;
            
        }
        
        
        return res;
        
    }
}