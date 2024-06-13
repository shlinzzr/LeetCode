// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<=n; i++){
            ans[i] = countingOnes(i);
        }
        
        return ans;
    }
    
    private int countingOnes(int n){
        int cnt=0;
        while(n>0){
            int mod = n%2;
            if(mod==1)
                cnt++;
            n=n/2;
        }
        
        return cnt;
    }
}