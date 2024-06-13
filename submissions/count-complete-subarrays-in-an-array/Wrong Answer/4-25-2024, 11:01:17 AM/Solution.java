// https://leetcode.com/problems/count-complete-subarrays-in-an-array

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        
        int len = nums.length;
        
        
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int res = 0;
        
        
        
        int lastValid = -1;
        for(int st=0; st<len; st++){
            
            boolean found = false;
            for(int ed=Math.max(lastValid, st); ed<len; ed++){
                
                int n = nums[ed];
                map.put(n, map.getOrDefault(n,0)+1);    
                if(map.size()<set.size()) continue;
                if(found==false){
                    lastValid = ed;
                    found = true;
                }
                    
                res++;
            }
            map.put(nums[st], map.get(nums[st])-1);
            if(map.get(nums[st])==0) map.remove(nums[st]);
        }
        
        return res;
        
    }
}