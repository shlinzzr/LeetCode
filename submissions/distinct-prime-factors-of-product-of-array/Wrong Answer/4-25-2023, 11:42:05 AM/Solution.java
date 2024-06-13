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
            }
        }
        
        return cnt;
        
        
        
        
        
        
        // long prod = 1;
        // for(long n : nums){
        //     prod*=n;
        // }
        
      
        
//         for(long i=2; i<=Math.sqrt(prod); i++){
            
//             while(prod %(i*i)==0){
//                 prod/=i;
                
//                 if(prod/i==1 && prod%i==0)
//                     cnt++;
//             }
                
//         }
        
//         for(long i=2; i<=prod; i++){
            
//            if(i%2==0 && isPrime((int)i))
//                 cnt++;
//         }
        
        
        // return (int)cnt;
        
        
        
        
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