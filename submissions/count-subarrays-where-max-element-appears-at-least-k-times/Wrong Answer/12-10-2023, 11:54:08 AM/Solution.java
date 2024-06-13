// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times

class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        int max = 0;
        for(int n : nums){
            max = Math.max(max, n);
        }
            
        
        TreeMap<Integer, Integer> map = new TreeMap<>();// nums[i], freq
        
        // TreeMap<Integer, Set<Integer>> fmap = new TreeMap<>(); // freq , Set<nums[i]>
        
        int len = nums.length;
        
        int res = 0;
        int ed =0;
       
        for(int st=0; st<len;st++){
            
             // System.out.println(st + " "+ed + " last="+map.lastKey());
            while(map.size()==0 || (ed<len && map.getOrDefault(max,0)<k)){
                
                map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);
                // int f = map.get(nums[ed]);
                // fmap.putIfAbsent(f, new HashSet<>());
                // fmap.get(f).add(nums[ed]);
                
                ed++;
                
            }
             
            
            //= [1,3,2,3,3], k = 2
                  // ed
            
            if(map.size()>0 && map.getOrDefault(max,0)>=k)
                res+=len-ed+1;
            
             // System.out.println(st + " "+ed + " res="+ res + " last="+map.lastKey());
//           
             // System.out.println(st + " "+(ed-1) + " res="+res);
//            
            
            // int f = map.getOrDefault(nums[st], 0);
            // fmap.get(f).remove(nums[st]);
            // if(fmap.get(f).size()==0)
            //     fmap.remove(f);
                                    
            map.put(nums[st], map.getOrDefault(nums[st],0)-1);
            if(map.get(nums[st])<=0)
                map.remove(nums[st]);
            
          
        }
        
        return res;
            
    }
}