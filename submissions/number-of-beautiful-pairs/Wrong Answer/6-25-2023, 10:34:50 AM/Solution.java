// https://leetcode.com/problems/number-of-beautiful-pairs

class Solution {
    public int countBeautifulPairs(int[] nums) {
        
        
        int len = nums.length;
        int cnt =0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                
                if(gcd(nums[i], nums[j])==1)
                    cnt++;
            }
            
            
        }
        
        return cnt;
    }
    
    
    
    private int gcd(int a, int b){
        
        if(b==0) return a;
        return gcd(b, a%b);
        
    }
        
}