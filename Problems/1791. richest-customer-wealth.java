// https://leetcode.com/problems/richest-customer-wealth

class Solution {
    public int maximumWealth(int[][] accounts) {
        int h = accounts.length;
        int w = accounts[0].length;
        
        int max = 0;
        for(int i=0; i<h; i++){
            int sum=0;
            for(int j=0; j<w; j++){
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        
        
        return max;
            
    }
}