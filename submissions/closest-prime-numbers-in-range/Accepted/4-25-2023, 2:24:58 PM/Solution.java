// https://leetcode.com/problems/closest-prime-numbers-in-range

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] arr = new boolean[right+1];
        Arrays.fill(arr, true);
        arr[0]=arr[1]=false;

        int min = Integer.MAX_VALUE;
        //finding prime numbers in range [2,right];
        findPrimes(right ,arr);
        
        //storing prime numbers in range[left,right] in list
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            if(arr[i])
                primes.add(i);
        }
      
        int[] res=null;
        //finding two prime numbers with smallest absolute difference
        for(int i=0;i<primes.size()-1;i++)
        {
            if(primes.get(i+1)-primes.get(i)<min)
            {
                min=primes.get(i+1)-primes.get(i);
                res=new int[]{primes.get(i),primes.get(i+1)};
            }
        }
        //if no result found return [-1,-1]
        return res==null? new int[]{-1,-1}:res;
    }
    
    private void findPrimes(int n,boolean[] arr)
    {
       for(int i = 2; i<=Math.sqrt(n); i++){
           if(arr[i]){
               for(int j=i*2; j<=n; j+=i)
                   arr[j] = false;
           }
       }  
    }
    
//     private boolean isPrime(int n ){
        
//         if(n<2)
//             return false;
        
//         if(n==2 ||n==3)
//             return true;
        
//         for(int i=4; i<Math.sqrt(n); i++){
            
//             if(n%i==0)
//                 return false;
//         }
        
//         return true;
        
        
//     }
    
}