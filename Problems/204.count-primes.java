// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        
        //sieveOfEratosthenes
        List<Integer> list = new ArrayList<>();
        
        if(n<=1) return 0;
        
        boolean [] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for(int i=2; i*i<=n; i++){
            if(primes[i]){
                for(int j=2; j*i<=n; j++){
                    primes[j*i] = false;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            // System.out.println(i + " " + primes[i]);
            if(primes[i]){
                list.add(i);
            }
        }
        
        return list.size();
    }
}