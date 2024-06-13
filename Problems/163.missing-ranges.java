// https://leetcode.com/problems/missing-ranges

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
         List<List<Integer>> res = new ArrayList<>();
        
        int len = nums.length;
        if(len==0){
            List<Integer> sub = new ArrayList<>();
            sub.add(lower);
            sub.add(upper);
            res.add(sub);
            return res;
        }
        
        if(lower<nums[0]){
            List<Integer> sub = new ArrayList<>();
            sub.add(lower);
            sub.add(nums[0]-1);
            res.add(sub);
        }
        
        for(int i=0; i<len-1; i++){
            
            int st = nums[i];
            int ed = nums[i+1];
            
            if(st+1==ed) continue;
            
            
            List<Integer> sub = new ArrayList<>();
            sub.add(st+1);
            sub.add(ed-1);
            res.add(sub);
        }
        
        if(upper > nums[len-1]){
            List<Integer> sub = new ArrayList<>();
            sub.add(nums[len-1]+1);
            sub.add(upper);
            res.add(sub);
        }
        
        return res;
        
    }
    
    // [-2 -1]
}