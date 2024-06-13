// https://leetcode.com/problems/distinct-prime-factors-of-product-of-array

class Solution {
    public int distinctPrimeFactors(int[] nums) {
     
        boolean[] arr = new boolean[1001];
        
        HashSet<Integer> pset = new HashSet<>();
        
        for(int i=2; i<=1000; i++){
            if(isPrime(i)){
                pset.add(i);
            }
        }
        
        HashSet<Integer> fac= new HashSet<>();
        
        for(int n: nums){
            
            for(int p : pset){
                if(n%p==0){
                    fac.add(p);
                }
            }
        }
        
        return fac.size();
        
        
        
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