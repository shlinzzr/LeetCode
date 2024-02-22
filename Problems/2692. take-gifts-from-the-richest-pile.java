// https://leetcode.com/problems/take-gifts-from-the-richest-pile

class Solution {
    public long pickGifts(int[] gifts, int k) {
        int len = gifts.length;
        
        while(k>0){
            k--;
            Arrays.sort(gifts);
            
            int n = gifts[len-1];
            
            gifts[len-1] = (int) Math.sqrt(n);
        }
        
        long sum=0;
        
        for(int g : gifts)
            sum+=g;
        
        return sum;
            
    }
}