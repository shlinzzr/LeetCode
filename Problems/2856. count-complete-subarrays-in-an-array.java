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
        
//         int ed =0;
//         for(int st=0; st<len; st++){
            
//             while(ed<len && map.size()<set.size()){
//                 map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
                
//                 if(map.size()<set.size())
//                     ed++;
                
//                 while(ed<st){
                    
//                     ed=st;
//                 }
                    
//             }
            
            
//              int val = len-ed;
//             System.out.println(st + " " + ed + " " + val);
//             res += len-ed;
            
//              map.put(nums[st], map.get(nums[st])-1);
//             if(map.get(nums[st])==0)
//                 map.remove(nums[st]);
//         }
        
        
        
        
        
        int st =0;
        for(int ed = 0; ed<len; ed++){
            
            map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
            if(map.size()<set.size())
                continue;
            
            // int val = len-ed;
            // System.out.println(st + " " + ed + " " + val + "zzz");
            
            res+= len-ed;
            
            while(map.size()==set.size()){
                map.put(nums[st], map.get(nums[st])-1);
                if(map.get(nums[st])==0)
                    map.remove(nums[st]);
                st++;
                
                
                if(map.size()==set.size()){
                    // System.out.println(st + " " + ed + " " + (len-ed));
                    res+=len-ed;                    
                }

            }
        }
       
        return res;
        
        
        
        
    }
}