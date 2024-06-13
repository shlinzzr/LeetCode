// https://leetcode.com/problems/count-the-number-of-square-free-subsets

class Solution {
    
    int M = (int) 1e9+7;
    long[][] dp = new long[1001][1025]; // [length of nums][2^10 of primes]
     
    int[] primes = new int[]{2,3,5,7,11,13,17,19,23,29};
    public int squareFreeSubsets(int[] nums) {
        int n = nums.length;

        dp[0][0]=1;

        long res = 0;
        for(int i=1; i<=n; i++){
            for(int state=0; state<(1<<10); state++){
                

                if(nums[i-1]==1){
                    dp[i][state] = dp[i-1][state] *2 %M;
                }else{
                    //not select nums[i-1]  : base case
                    dp[i][state] = dp[i-1][state];

                    // select nums[i-1]
                    int s = encode(nums[i-1]);
                    if(s!=-1 && (state & s)==s){
                        dp[i][state] =  (dp[i][state] + dp[i-1][state-s])%M;
                    }
                }

                if(i==n){
                    res = (res + dp[i][state] )%M;
                }
            }
        }

        return (int)(res+M-1)%M; // 減去什麼都不選
    }

    private int encode(int x){

        int s = 0;
        for(int i=0; i<10; i++){
            int cnt=0; 
            while(x%primes[i]==0){
                cnt++;
                x/=primes[i];
            }

            if(cnt>1){
                return -1;
            }else if(cnt==1){
                s = (1<<i);
            }
        }

        return s;
    }
}