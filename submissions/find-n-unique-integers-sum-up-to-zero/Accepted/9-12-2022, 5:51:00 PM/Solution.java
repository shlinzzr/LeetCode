// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero

class Solution {
    public int[] sumZero(int n) {
        
        int[] res = new int[n];
      
            
        int val=n/2;
        for(int i=0; i<n/2; i++){
            res[i]=val;
            res[n-i-1]=-val;
            val--;
        }

            
        if(n%2==1){
            res[n/2]=0;
            
        }
        
        return res;
    }
}