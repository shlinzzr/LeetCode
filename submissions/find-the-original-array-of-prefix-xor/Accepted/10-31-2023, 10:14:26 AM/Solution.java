// https://leetcode.com/problems/find-the-original-array-of-prefix-xor

class Solution {
    public int[] findArray(int[] pref) {
        // pref[0] = arr[0]
        // pref[1] = arr[0] ^ arr[1]; =>  arr[1]; = pref[1] ^ arr[0] 
        // pref[2] = arr[0] ^ arr[1] ^ arr[2] = > arr[2] = pref ^ arr[0] ^ arr[1]
        
        int len = pref.length;
        
        
//         int[] prexor = new int[len];
//         for(int i=0; i<len ;i++){
//             prexor[i] = (i==0) ? pref[0] : pref[i]^prexor[i-1];
//         }
        
        
        int[] arr = new int[len];
        
        int xor = 0;
        
        for(int i=0; i<len; i++){
            
            if(i==0){
                arr[0] = pref[0];
                xor = arr[0];
            }else{
                
                arr[i] = xor ^ pref[i];
                xor ^= arr[i];
            }
        }
        
        return arr;
        
    }
}