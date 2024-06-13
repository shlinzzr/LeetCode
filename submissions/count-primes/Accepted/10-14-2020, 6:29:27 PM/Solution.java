// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        /*
        *  Time Limit Exceeded
        */
//         ArrayList<Integer> a = new ArrayList();
            
//         if(n<=2)
//             return 0;
        
//         for(int i=2; i<n; i++){
            
//             boolean isPrime = true;
//             for(int j=0; j<a.size(); j++){
//                 if(i%a.get(j)==0){
//                     isPrime = false;
//                     break;
//                 }
//             }
            
//             if(isPrime){
//                 a.add(i);
//             }
            
            
//         }
//         return a.size();
        
        
        
        
    if(n <=1 ) return 0;
    
    boolean[] notPrime = new boolean[n];        
    notPrime[0] = true; 
    notPrime[1] = true; 

    for(int i = 2; i < Math.sqrt(n); i++){
        if(!notPrime[i]){
            for(int j = 2; j*i < n; j++){
                notPrime[i*j] = true; 
            }
        }
    }
    
    int count = 0; 
    for(int i = 2; i< notPrime.length; i++){
        if(!notPrime[i]) count++;
    }
    return count; 

        
    }
}