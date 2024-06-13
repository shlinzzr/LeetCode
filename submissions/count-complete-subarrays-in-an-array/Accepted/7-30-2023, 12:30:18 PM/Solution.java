// https://leetcode.com/problems/count-complete-subarrays-in-an-array

class Solution {
    
    public int countCompleteSubarrays(int[] nums) {
        
         HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        int k = set.size();
        System.out.println( atMost(nums, k));
        
        return atMost(nums, k)- atMost(nums, k-1);
    }
    
    private int atMost(int[] nums, int k){
        
        int cnt= 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int st=0;
        for(int ed=0; ed<nums.length; ed++){
            
            map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
            
            while(map.size()>k){
                map.put(nums[st], map.getOrDefault(nums[st], 0)-1);
                if(map.get(nums[st])==0)
                    map.remove(nums[st]);
                st++;
            }
            
            cnt += ed-st+1;
        }
        
        return cnt;
        
        
    }
    
    
    
    
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
    
    
//     public int countCompleteSubarrays(int[] nums) {
//         int len = nums.length;
//         HashSet<Integer> set = new HashSet<>();
//         for(int n : nums){
//             set.add(n);
//         }
        
//         int siz = set.size();
        
//         LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//         List<Integer> list= new ArrayList<>();
//         int st=0;
//         for(int ed=0; ed<len; ed++){
            
//             map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
//             list.add(nums[ed]);
//             if(map.size()<siz)
//                 continue;
            
//            for(int j=ed; j<len && map.containsKey(nums[j]); j++){
               
//                 for(int k : map.keySet()){
//                     System.out.print(k + ":" + map.get(k) + ", ");
//                 }
//                   System.out.println();
               
               
//                 System.out.println(list);
               
               
//                res++;
//            }
            
//             map.put(nums[st], map.getOrDefault(nums[st], 0)-1);
            
//             if(map.get(nums[st])==0)
//                 map.remove(nums[st]);
//             st++;
//             list.remove(0);
            
            
//         }
        
//         return res;
            
        
//     }
}