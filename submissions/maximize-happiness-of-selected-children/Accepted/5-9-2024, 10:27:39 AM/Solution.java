// https://leetcode.com/problems/maximize-happiness-of-selected-children

class Solution {
    public long maximumHappinessSum(int[] h, int k) {
        
        Arrays.sort(h);
        
        int idx=h.length-1;
        
        int minus = 0;
        long sum = 0;
        while(k-->0){
            
            int val = h[idx--] - minus;
            if(val<0) val=0;
            
            minus++;
            sum+= val;
        }
        
        return sum;
        
    }
}