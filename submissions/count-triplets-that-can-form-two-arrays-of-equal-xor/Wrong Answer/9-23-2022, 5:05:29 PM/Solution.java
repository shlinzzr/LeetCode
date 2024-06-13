// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor

class Solution {
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int cnt=0;
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                
                int xor=0;
                for(int k=i; k<=j; k++){
                    xor ^= arr[k];
                }
                
                if(xor==0){
                   cnt += getCnt(j-i);
                }
                    
                
            }
        }
        
        return cnt;
    }
    
    private int getCnt(int n){
        int res =1;
        for(int i=1; i<=n; i++){
            res*=i;
        }
        
        return res;
    }
}