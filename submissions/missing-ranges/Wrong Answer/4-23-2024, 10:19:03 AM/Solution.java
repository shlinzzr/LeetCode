// https://leetcode.com/problems/missing-ranges

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
         List<List<Integer>> res = new ArrayList<>();
        
        int len = nums.length;
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(lower);
        set.add(upper);
        for(int n : nums){
            set.add(n);
        }
        
        List<Integer> list = new ArrayList<>(set);
        for(int i=0; i<list.size()-1; i++){
            
            int st = list.get(i);
            int ed = list.get(i+1);
            if(ed==st+1) continue;
            
            List<Integer> sub = new ArrayList<>();
            sub.add(st==lower ? st : st+1);
            sub.add(ed==upper ? ed : ed-1);
            res.add(sub);
        }
        return res;
        
    }
}