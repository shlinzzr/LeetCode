// https://leetcode.com/problems/find-the-original-array-of-prefix-xor

class Solution {
    public int[] findArray(int[] pref) {
        // pref[0] = arr[0]
        // pref[1] = arr[0] ^ arr[1]; =>  arr[1]; = pref[1] ^ arr[0] 
        // pref[2] = arr[0] ^ arr[1] ^ arr[2] = > arr[2] = pref ^ arr[0] ^ arr[1]
        
        int len = pref.length;
        
        int[] arr = new int[len];
        
        for(int i=0; i<len; i++){
            
            if(i==0){
                arr[0] = pref[0];
            }else{
                int xor = pref[i];
                for(int j=0; j<i; j++){
                    xor ^= arr[j];
                }
                arr[i] = xor;                
            }
        }
        
        return arr;
        
    }
}