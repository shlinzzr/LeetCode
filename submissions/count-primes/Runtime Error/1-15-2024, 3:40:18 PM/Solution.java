// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        
        //sieveOfEratosthenes
        List<Integer> list = new ArrayList<>();
        
        boolean [] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for(int i=2; i*i<=n; i++){
            if(primes[i]){
                for(int j=2*i; j<=n; j+=i){
                    primes[j] = false;
                }
            }
        }
        
        for(int i=2; i<=n; i++){
            if(primes[i]){
                list.add(i);
            }
        }
        
        return list.size();
    }
}