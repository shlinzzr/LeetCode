// https://leetcode.com/problems/longest-palindrome

// class Solution {
//     public int longestPalindrome(String s) {
        
//         int max=0;
        
//         for(int i=0; i<s.length(); i++){
            
//             for(int j=0; j<=i; j++){
                
//                 if(isPalindrome(s.substring(j, s.length()-i+j)))
//                     return s.length()-i;
//             }
//         }
        
//         return -1;
//     }
    
//     private boolean isPalindrome(String s){
        
        
//         for(int i=0; i<s.length()/2; i++){
//             if(s.charAt(i)!=s.charAt(s.length()-1-i))
//                 return false;
//         }
//         return true;
        
//     }
    
// }

class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[100];
        
        for(char c : s.toCharArray()){  //'a'==97, 'A'==65
            arr[c-'a']++;
        }
        
        int max =0;
        
        boolean plus = false;
        for(int i : arr){
            if(i>=2)
                max += i/2*2;
            
            if(i%2==1)
                plus=true;
        }
        
        if(plus)
            max+=1;
        
        return max;
        
        
        
        
        
        
        
    }
}
