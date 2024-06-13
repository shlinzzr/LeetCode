// https://leetcode.com/problems/sum-of-floored-pairs

class Solution {
    public int sumOfFlooredPairs(int[] nums) {

        int N = (int) 1e5;
        int M = (int) 1e9+7;
        int len = nums.length;

        int[] freq = new int[N+1];
        for(int n : nums) 
            freq[n]++;


        int[] presumFreq = new int[N+1];
        for(int i=1;i<=N;i++) 
            presumFreq[i] = presumFreq[i-1] + freq[i];
        
        long res=0;
        
        for(int x=1; x<=N;x++){
            if(freq[x]==0) continue; //沒有出現x => continue 
            
            // [i * j, i * (j + 1)) 
            // [x*k, x*(k+1)-1]

            long sum=0;
            for(int k=1; x*k<=N;k++){
                int lower=x*k-1;
                int upper=x*(k+1)-1;
                
                int count= presumFreq[Math.min(N ,upper)] - presumFreq[lower]; 
                
                sum+=count*k;
            }

            sum %= M;
            res = ( res  +  sum*freq[x]) %M;
        }
        return (int)res;
    }

    // {x, y} => sum of y/x

    // x = 5
    // y ={5, 9} + {10, 14}     ... {x*k, x*(k+1)-1}
    //      a*1     b*2 + ....
    // a : 5~9有a 個數字
    // b : 10~14有 b個數字

    // for all k=1,2,3.... k




    
    

        
}