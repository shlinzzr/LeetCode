// https://leetcode.com/problems/count-complete-subarrays-in-an-array

class Solution {
    
    
    int res = 0;
    /*
    private void helper(int[] nums,  HashMap<Integer, Integer> map, int target, int st){
        
        if(map.size()==target){
            res++;
            for(int k : map.keySet()){
                System.out.print(k + ":" + map.get(k) + ", ");
            }
              System.out.println();
            return;
        }
            
        
        for(int i=st; i<nums.length; i++){
            
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            helper(nums, map, target, i+1);
            map.put(nums[i], map.get(nums[i])-1);
            if(map.get(nums[i])<=0)
                map.remove(nums[i]);
        }
        
        
        
    }*/
    
    
    public int countCompleteSubarrays(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        int siz = set.size();
        
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        
        // helper(nums, map, target, 0);
        // return res;
        
        int res= 0;
        
//         int ed =0;
//         for(int st=0; st<len; st++){
            
            
//              System.out.println("st="+st+ " res="+res);
//             for(int k : map.keySet()){
//                 System.out.print(k + ":" + map.get(k) + ", ");
//             }
//               System.out.println();
            
            
            
            
//             while(ed<len && map.size()<siz){
                
//                  if(map.size()==siz)
//                     res++;
                
//                 map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
//                 ed++;
                
               
//             }
            
//            map.put(nums[st], map.getOrDefault(nums[st], 0)-1);
//            if(map.get(nums[st])==0)
//                 map.remove(nums[st]);
            
//         }
        
//         return res;
        
        
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
            if(map.size()<=siz)
                continue;
            
            while(st<=ed && map.size()==siz){
               
                res += (ed-1)
                
                map.put(nums[st], map.getOrDefault(nums[st],0)-1);
                if(map.get(nums[st])==0)
                    map.remove(nums[st]);
                
                st++;
            }
        }
        
        return res;
            
        
    }
}