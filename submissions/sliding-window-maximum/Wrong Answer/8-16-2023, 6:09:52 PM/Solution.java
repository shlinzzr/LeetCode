// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        TreeSet<Integer> set = new TreeSet<>();
        int len = nums.length;
        int[] res = new int[len-k+1];
        
        
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<len; i++)
        {
            
            while (set.size()>k)
                set.remove(set.lower(nums[i])); //照c++ function translate to java應該是ceiling, 照演算法邏輯判斷 應該是floor
            
            set.add(nums[i]);
            
            if (set.size()<k) continue;
            list.add(set.last());
            
        }
        
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        
        
        return res;
        
        
        
        
        
        
        
        
        
        
        //         TreeMap<Integer, Integer> map = new TreeMap<>();
        // int len = nums.length;
        // int[] res = new int[len-k+1];
//         for(int i=0; i<len ;i++){
//             int cur = nums[i];
//             map.put(cur, map.getOrDefault(cur, 0)+1);
            
//             if(map.size()>k){
//                 map.put(nums[i-k], map.get(nums[i-k])-1);
//                 if(map.get(nums[i-k])==0)
//                     map.remove(nums[i-k]);
//             }
            
//             if(i+1-k>=0){
//                 res[i+1-k] = map.lastKey();
//             }
//         }
        
//         return res;
        
        
        
    }
}