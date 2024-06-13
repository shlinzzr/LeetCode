// https://leetcode.com/problems/prime-pairs-with-target-sum

class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i<=n/2; i+=2){
            
            int x = i; 
            int y = n-x;
            if(isPrime(x) && isPrime(y)){
                res.add(Arrays.asList(x,y));
            }
        }
        
        
        return res;
        
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