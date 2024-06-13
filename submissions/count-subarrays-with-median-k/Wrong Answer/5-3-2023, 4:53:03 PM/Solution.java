// https://leetcode.com/problems/count-subarrays-with-median-k

class Solution {
    public int countSubarrays(int[] nums, int k) {
        int len = nums.length;
        
        int cnt=0;
        
        for(int i=0; i<len; i++){
            
            if(nums[i]==k){
                int odd = extend(nums, i, i, k);
                cnt+=odd;
                
                // System.out.println(odd);
            
                if(i+1<len && nums[i+1]>k){
                    int even = extend(nums, i, i+1, k);    
                    cnt+=even;    
                    
                    // System.out.println(even);
                }
                
            }
        }
        
        return cnt;
    }
    
    
    
    // 1 [4, 5] 
    
    //[2,3,1]
    
    // st=2 ed=2 k=3
    
    private int extend(int[] nums, int st, int ed, int k){
        int cnt=0;
        int pre=0, post=0;
        
        int len = nums.length;
        
        while(st>=0 && ed<len && pre==post){
            
            
            
            
            if(nums[st]==k || nums[ed]==k){
                pre++;
                post++;
                st--;
                ed++;
                cnt++;
                continue;
            }
            
            if(nums[st]<k){
                pre++;
                st--;
            }
                
            
            if(nums[ed]>k){
                post++;
                ed++;
            }
            
            if(pre==post)
                cnt++;
        }
        
        return cnt;
        
        
    }
}