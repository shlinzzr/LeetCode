// https://leetcode.com/problems/distinct-prime-factors-of-product-of-array

class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        Arrays.sort(nums);
        
        int len = nums.length;
          int cnt=0;
        
        HashSet<Integer> set= new HashSet<>();
        for(int n: nums){
            
            for(int p : set){
                while(n%p==0){
                    n/=p;
                }
                
               
            }
            
            if(isPrime(n)){
                    cnt++;
                    set.add(n);
            }else{
                
                  for(int i=2; i<=Math.sqrt(n); i++){
                      
                        boolean valid=false;
                        while(n%i==0 ){
                            valid=true;
                            n/=i;
                        }
                      
                       if(valid)
                          cnt++;
                    }
            }
        }
        
        return cnt;
    }
    
    
    private boolean isPrime(int n){
        
        if(n<2) return false;
        
        if(n==2)
            return true;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            
            if(n%i==0 )
                return false;
        }
        
        return true;
    }
}