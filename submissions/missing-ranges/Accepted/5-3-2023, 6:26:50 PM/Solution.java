// https://leetcode.com/problems/missing-ranges

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int len = nums.length;
        
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int n: nums){
            set.add(n);
        }
        
        set.add(lower-1);
        set.add(upper+1);
        
        List<List<Integer>> res = new ArrayList<>();
        
        
        for(int i=lower; i<=upper; i++){
            
            if(set.contains(i)){
                continue;
            }
            
            
            int st = set.floor(i)+1;
            
            int ed = set.ceiling(i)-1;
            
            res.add(Arrays.asList(st, ed));
            
            i=ed;
            
        }
        
        return res;
    }
}