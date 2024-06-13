// https://leetcode.com/problems/count-subarrays-with-median-k

class Solution {
    public int countSubarrays(int[] nums, int k) {
        int idx =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==k){
                idx = i;
                break;
            }
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        int bal =0;
        for(int i =idx;i<nums.length;i++){
            bal += nums[i]==k? 0 : nums[i]<k? -1 :1;
            cnt.put(bal, cnt.getOrDefault(bal,0)+1);
        }

        int res = 0;
        bal =0;
        for(int i= idx;i>=0.;i--){
            bal += nums[i]==k? 0 : nums[i]<k? -1 :1;
            res+= cnt.getOrDefault(-bal,0) + cnt.getOrDefault(-bal+1,0);
        }
        return res;
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