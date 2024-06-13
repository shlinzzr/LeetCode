// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        
        ArrayList<Integer> a = new ArrayList();
            
        if(n<=2)
            return 0;
        
        
        for(int i=2; i<n; i++){
            
            boolean isPrime = true;
            for(int j=0; j<a.size(); j++){
                if(i%a.get(j)==0){
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime){
                a.add(i);
            }
            
            
        }
        return a.size();
    }
}