// https://leetcode.com/problems/contains-duplicate-iii

class Solution {
    
//      public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//         if (nums == null || nums.length == 0 || indexDiff <= 0) {
//             return false;
//         }
//         TreeSet<Integer> set = new TreeSet<>();
//         int st =0;
         
//         for (int ed = 0; ed < nums.length; ed++) {

//             final Integer floor = set.floor(nums[ed] + valueDiff);
//             final Integer ceil = set.ceiling(nums[ed] - valueDiff);
//             if ((floor != null && floor >= nums[ed]) || (ceil != null && ceil <= nums[ed])) {
//                 return true;
//             }

//             set.add(nums[ed]);
//             if (ed-st==indexDiff) {
//                 set.remove(nums[st++]);
//             }
//         }

//         return false;
//      }
    
    
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff <= 0) {
            return false;
        }
        
        int len = nums.length;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int st =0;
        for(int ed=0; ed<len;ed++){
            Integer floor = map.floorKey(nums[ed]+valueDiff);
            Integer ceiling = map.ceilingKey(nums[ed]-valueDiff);
            
            
            if( (floor!=null && floor>=nums[ed] )|| (ceiling!=null && ceiling<=nums[ed]))
                return true;
            
            map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);
            
            
            if(ed-st==indexDiff){
                map.put(nums[st], map.get(nums[st])-1);
                
                if(map.get(nums[st])==0) 
                   map.remove(nums[st]);
                   
                st++;
            }
        }
                   
                   return false;
    }
}