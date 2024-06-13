// https://leetcode.com/problems/majority-element-ii

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> res = new HashSet<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int len = nums.length;
        
        // int max = 0;
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
            
            if(map.get(n)> len/3)
                res.add(n);
            
            // max = Math.max(max, map.get(n));
        }
        
        
        return new ArrayList<>(res);
        
        
        
        
        
    }
}