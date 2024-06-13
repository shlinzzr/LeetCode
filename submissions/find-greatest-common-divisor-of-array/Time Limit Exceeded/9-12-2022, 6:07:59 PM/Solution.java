// https://leetcode.com/problems/find-greatest-common-divisor-of-array

class Solution {
    public int findGCD(int[] nums) {
        
        int gcd =0;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                
                int n1 = nums[i];
                int n2 = nums[j];
                int div = Math.min(n1,n2);
                
                boolean find=false;
                while(div>0){
                    if(n1%div==0 && n2%div==0){
                        if(gcd==0){
                        
                            gcd=div;
                            break;
                        
                        }else if(gcd%div==0 || div%gcd==0){
                            gcd = Math.min(gcd, div);
                            break;
                        }
                        div--;
                    }
                }
                
                
                
            }
        }
        
        return gcd;
        
    }
}