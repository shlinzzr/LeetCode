// https://leetcode.com/problems/missing-ranges

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
                
        int len = nums.length;
        
        TreeSet<Integer> set = new TreeSet<>();

        set.add(lower-1);
        set.add(upper+1);
        for(int i=0; i<len; i++){
            set.add(nums[i]);
        }
        
        for(int i=lower; i<=upper; i++){
            
            if(set.contains(i))
                continue;
            
            int f = set.floor(i);
            int c = set.ceiling(i);
            
            List<Integer> list =new ArrayList<>();    
            list.add(f+1);
            list.add(c-1);
            res.add(list);
            
            i = c;
            
        }
        
        return res;
        
    }
}