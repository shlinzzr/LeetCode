// https://leetcode.com/problems/lexicographically-smallest-palindrome

class Solution {
    public String makeSmallestPalindrome(String s) {
        
        int len = s.length();
        int st=0, ed=len-1;
        
        
        char[] arr = s.toCharArray();
        
        while(st<ed){
           if(arr[st]<arr[ed]){
               arr[ed] = arr[st];
           }else if(arr[ed]<arr[st]){
               arr[st] = arr[ed];
           }
            st++;
            ed--;
        }
        
        
        return new String(arr);
    }
    
//     private boolean isPal(String s ){
        
//         int 
        
//     }
}