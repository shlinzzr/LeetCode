// https://leetcode.com/problems/richest-customer-wealth

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        
        for(int[] cust : accounts){
            
            int total = 0;
            for(int m : cust){
                
                total += m;
            }
            
            max = Math.max(max, total);
            
            
        }
        
        return max;
    }
}