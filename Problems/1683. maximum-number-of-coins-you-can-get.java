// https://leetcode.com/problems/maximum-number-of-coins-you-can-get

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int idx = piles.length/3;
        
        int max= 0;
        for(int i=piles.length-2; i>=idx ; i-=2){
            max+=piles[i];
            
        }
        
        return max;
    }
}