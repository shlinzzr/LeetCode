// https://leetcode.com/problems/sum-of-distances

class Solution {
    public long[] distance(int[] nums) {
        
        // huifeng 我大哥 
        // 找中位數。 相同題型 2121, 1685, 2615
        // https://www.youtube.com/watch?v=4OSbgIQV6v8
        // https://www.youtube.com/watch?v=hgnoldhgJPI
        
        
        int len = nums.length;
        long[] res = new long[len];
        
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            int val = en.getKey();
            List<Integer> list = en.getValue();
            long sum = 0;
            for(int i=0; i<list.size(); i++){
                sum += list.get(i) - list.get(0);
            }
            res[list.get(0)] = sum;
            
            for(int i=1; i<list.size(); i++){
                sum +=  (list.get(i)-list.get(i-1))*i;
                sum -=  (list.get(i)-list.get(i-1))*(list.size()-i) ;
                
                
                res[list.get(i)] = sum ;
            }
            
        }
        
        
        
        
        return res;
    }
}
