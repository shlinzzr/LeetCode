// https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii

class Solution {
    public int[] findIndices(int[] nums, int id, int vd) {
        
        
        int len = nums.length;
        
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        
        
        for(int i=0; i<len; i++){
            
            int n = nums[i];
            
            
            Integer ceilKey = map.ceilingKey(n+vd);
            Integer florKey = map.floorKey(n-vd);
            
            
            
            
            if(ceilKey!=null){
                
                TreeSet ceil = map.get(ceilKey);
                
                if(ceil.floor(i-id)!=null){
                    return new int[]{i, (int)ceil.floor(i-id)};
                }
            }
            
            if(florKey!=null){
                
                TreeSet flor = map.get(florKey);
                if(flor.floor(i-id)!=null){
                     return new int[]{i, (int)flor.floor(i-id)};
                }
            }
            
            map.putIfAbsent(n, new TreeSet<>());
            map.get(n).add(i);
            
        }
        
        return new int[]{-1, -1};
        
        
//         int[] res = new int[]{-1, -1};
        
//         int len = nums.length;
//         for(int i=0; i<len; i++){
//             for(int j=i+indexDifference; j<len; j++){
                
//                 if(Math.abs(nums[i]-nums[j])>=valueDifference){
//                     return new int[]{i, j};
//                 }
                
//             }
//         }
        
//         return res;
    }
}