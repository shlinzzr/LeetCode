// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times

class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();// nums[i], freq
        
        TreeMap<Integer, Set<Integer>> fmap = new TreeMap<>(); // freq , Set<nums[i]>
        
        int len = nums.length;
        
        int res = 0;
        int ed =0;
       
        for(int st=0; st<len;st++){
            
            
            while(ed==0 || (ed<len && map.get(map.lastKey())<k)){
                
                map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);
                int f = map.get(nums[ed]);
                fmap.putIfAbsent(f, new HashSet<>());
                fmap.get(f).add(nums[ed]);
                
                ed++;
                
            }
            // System.out.println(st + " "+ed + " res="+fmap.lastKey());
//             
            
            //= [1,3,2,3,3], k = 2
                  // ed
            
            if(fmap.lastKey()>=k)
                res+=len-ed+1;
            
             // System.out.println(st + " "+(ed-1) + " res="+res);
//            
            
            int f = map.get(nums[st]);
            fmap.get(f).remove(nums[st]);
            if(fmap.get(f).size()==0)
                fmap.remove(f);
                                    
            map.put(nums[st], map.getOrDefault(nums[st],0)-1);
           
            
          
        }
        
        return res;
            
    }
}