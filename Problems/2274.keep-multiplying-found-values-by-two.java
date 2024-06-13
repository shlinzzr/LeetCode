// https://leetcode.com/problems/keep-multiplying-found-values-by-two

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        
        
        while(set.contains(original)){
            original*=2;
        }
        
        return original;
    }
}