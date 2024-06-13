// https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> res = new ArrayList<>();
        
        
        
        for(int target : queries){
            long sum = 0;
            
            for(int n: nums){
                sum += Math.abs(target-n);
            }
            
            res.add(sum);
        }
        
        return res;
        
    }
}