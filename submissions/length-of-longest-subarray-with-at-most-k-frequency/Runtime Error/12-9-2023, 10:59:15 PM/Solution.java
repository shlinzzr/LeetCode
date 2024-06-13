// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        TreeMap<Integer, Set<Integer>> fmap = new TreeMap<>();
        
        int len = nums.length;
        
        int res = 0;
        int st= 0;
        
        for(int i=0; i<len;i++){
            
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            int f =map.get(nums[i]);
            fmap.putIfAbsent(f, new HashSet<>());
            fmap.get(f).add(nums[i]);
            
            // if(fmap.lastKey()<=k)
            //     continue;
            
            while(fmap.lastKey()>k){
                f = map.get(nums[st]);
                map.put(nums[i], map.getOrDefault(nums[i],0)-1);
                fmap.get(f).remove(nums[i]);
                
                if(fmap.get(f).size()==0)
                    fmap.remove(f);
                st++;
                
            }
            
            res = Math.max(res, i-st+1);
            
        }
        
        return res;
            
        
    }
}