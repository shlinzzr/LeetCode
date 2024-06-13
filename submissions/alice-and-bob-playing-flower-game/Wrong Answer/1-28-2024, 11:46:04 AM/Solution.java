// https://leetcode.com/problems/alice-and-bob-playing-flower-game

class Solution {
    public long flowerGame(int n, int m) {
        
        
        if((n+m)%2==0) return 0;
        
        long cnt = 0;
        
        
        int N = m+n;
        int K = (m+n+1)/2;
        
        
        return getCnt(n,m); 
    }
    HashMap<String, Long> map = new HashMap<>();
    private long getCnt(int n, int m){
        
        if(n<=0 || m<=0) return 0L;
        if(n==1 || m==1) return 1L;
        
        if(map.containsKey(n+"_"+m))
            return map.get(n+"_"+m);
        
        
        long val =  1+getCnt(n, m-2)+getCnt(n-1, m-1)+getCnt(n-2, m);
        map.put(n+"_"+m, val);
        return val;
    }
        
//         long 
        
    

//     C = factorial(N) / (factorial(M) * factorial(N - M));

//     private long factorial(int n)
//     {
//         if(n == 1)
//             return 1;
//         else
//             return n * factorial(n - 1) ;
//     }
}