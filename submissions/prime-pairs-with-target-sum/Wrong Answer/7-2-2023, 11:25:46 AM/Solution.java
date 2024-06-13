// https://leetcode.com/problems/prime-pairs-with-target-sum

class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        
        
    
        
        List<List<Integer>> res = new ArrayList<>();
        if(n==1)
            return res;
        
        
        List<Integer> ps = sieveOfEratosthenes( n);
        HashSet<Integer> set = new HashSet<>(ps);
        
        for(int i=0; i<=ps.size()/2; i++){
            
            Integer x = ps.get(i);
            if(x==null)
                break;
            if(set.contains(n-x)){
                 res.add(Arrays.asList(x,n-x));
            }
            
            
        }
        
        
//         for(int i=1; i<=n/2; i+=1){
            
//             int x = i; 
//             int y = n-x;
//             if(isPrime(x) && isPrime(y)){
//                 res.add(Arrays.asList(x,y));
//             }
//         }
        
        
        return res;
        
    }
    
    
    
    public List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0]=false;
        primes[1]=false;
          
        for (int i = 2; i*i <= n; i++) {
            if (primes[i]) {
                for (int j = 2*i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                result.add(i);
            }
        }
        return result;
    }
    
    
     
     public boolean isPrime(int n)
    {
        if(n<2)
        {
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    
}