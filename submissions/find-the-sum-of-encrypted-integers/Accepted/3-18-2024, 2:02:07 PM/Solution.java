// https://leetcode.com/problems/find-the-sum-of-encrypted-integers

class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        
        
        int res = 0;
        for(int n : nums){
            int t = n;
            int max=0;
            while(t>0){
                int m = t%10;
                if(m>max){
                    max = m;
                }
                t/=10;
            }
            
             t = n;
            int sum = 0;
            while(t>0){
                sum=sum*10+max;
                t/=10;
            }
            res+= sum;
        }
        
        return res;
    }
    
  
}