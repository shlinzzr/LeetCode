// https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        
        Set<Integer> set= new HashSet<>();
        
        int xor = 0;
        int cnt = 0;
        for(int n : nums){
            if(set.add(n)==false){
                xor ^= n;
            } 
        }
        
        return xor;
        
        
    }
}