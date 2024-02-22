// https://leetcode.com/problems/sum-of-distances

class Solution {
    public long[] distance(int[] nums) {
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
                sum += (long)(list.get(i) - list.get(0));
            }
            res[list.get(0)] = sum;
            
            
             // System.out.println(en.getKey() + " " + sum);
            
            
            for(int i=1; i<list.size(); i++){
                sum += (long) (list.get(i)-list.get(i-1))*i;
                sum -= (long) (list.get(i)-list.get(i-1))*(list.size()-i) ;
                
                
                res[list.get(i)] = sum ;
            }
            
        }
        
        
        
        
        return res;
    }
}
