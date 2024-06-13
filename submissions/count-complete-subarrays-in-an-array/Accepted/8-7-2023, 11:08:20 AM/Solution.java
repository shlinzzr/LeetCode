// https://leetcode.com/problems/count-complete-subarrays-in-an-array

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int len = nums.length;
        
        HashSet<Integer> set= new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        
        HashMap<Integer, Integer> map =new HashMap<>();
        
        int res = 0;
        
        int st =0;
        for(int ed = 0; ed<len; ed++){
            
            map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
            if(map.size()<set.size())
                continue;
            
            res+= len-ed;
            
            while(map.size()==set.size()){
                map.put(nums[st], map.get(nums[st])-1);
                if(map.get(nums[st])==0)
                    map.remove(nums[st]);
                st++;
                
                if(map.size()==set.size()){
                    res+=len-ed;                    
                }

            }
        }
       
        return res;
    }
}