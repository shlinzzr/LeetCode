// https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors

class Solution {
    public int smallestValue(int n) {
        
        int prev=-1;
        
        while(n!=prev){
            prev=n;
            List<Integer> list = findFac(n);
            int sum =0; 
            for(int a: list){
                sum+=a;
                // System.out.println(a);
            }
            // System.out.println(sum);
            // System.out.println("---");
            n=sum;
        }
        
        return n;
        
        
    }
    
    private List<Integer> findFac(int n){
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=2; i<=n; i++){
            
            while(n%i==0){
                list.add(i);
                n/=i;
            }
        }
        
        return list;
        
    }
    
    
//     private List<Integer> findPrime(int n){
        
        
//         boolean[] arr = new boolean[n+1];
//         Arrays.fill(arr, true);
//         arr[0] = false;
//         arr[1] = false;
        
//         if(n<2) return new ArrayList<>();
        
//         for(int i=2; i<=Math.sqrt(n); i++){
//             if(arr[i]){
//                 for(int j = i*i; j<=n; j+=i){
//                     arr[j]=false;
//                 }
//             }
//         }
        
//         List<Integer> list = new ArrayList<>();
//         for(int i=0; i<=n; i++){
//             if(arr[i])
//                 list.add(i);
//         }
//         return list;
//     }
}