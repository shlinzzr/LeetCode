// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int len = nums.length;
        
        // int d // divisor
        
        
        int max = 0;
        int sum = 0;
        for(int n: nums){
            sum +=n;
            max= Math.max(n, max);
        }
        
        int st=1, ed=max;
        
        while(st<ed){
            int mid = st + (ed-st)/2;
            
            if(isOk(nums, mid, threshold)){
                ed = mid;
            }else{
                st = mid+1;
            }
            
            
        }
        
        return st;
        
        
    }
    
    private boolean isOk(int[]nums, int mid, int threshold){
        
        int sum  = 0;
        
        for(int n : nums){
            
            int res = getDiv(n, mid);
            sum += res;
        }
        return sum <= threshold;
    }
    
    
    private int getDiv(int x, int d){
        
        if(x%d==0)
            return x/d;
        
        return x/d+1;
    }
}