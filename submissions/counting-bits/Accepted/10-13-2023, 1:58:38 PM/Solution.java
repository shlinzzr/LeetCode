// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        
        // recur Time O(nlgn)

        int[] res = new int[n+1];
        for(int i=0; i<=n; i++){
            res[i] = iterative(i);
        }
        return res;

        // dp: Time : O(n)
        // int[] dp = new int[n+1];
        
        // // 0 ->   0 
        // // 1 ->   1 -> dp[n-1] +1 =1
        // // 2 ->  10 -> dp[n-2] +1 =1
        // // 3 ->  11 -> dp[n-2] +1 =2
        // // 4 -> 100 -> dp[n-4] +1 =1
        // //.     ....
        // // dp[i] = dp[i-offset]  +1;
        // int offset = 1;
        // for(int i=1; i<=n; i++){
            
        //     if(offset*2==i){
        //         offset*=2;    
        //     }
        //     dp[i] = dp[i-offset]+1;
        // }
        
        // return dp;
    }

    private int iterative(int i){
        int res = 0;

        while(i>0){

            if(i%2==1)
                res++;
            i/=2;
        }
        return res;


    }



    private int recursive(int i){
        
        if(i==0) return 0;
        if(i==1) return 1;

        if(i%2==0)  return recursive(i/2);
        
        return 1+recursive(i/2);
    }



}