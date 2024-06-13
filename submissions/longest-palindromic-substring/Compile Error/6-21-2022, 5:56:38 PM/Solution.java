// https://leetcode.com/problems/longest-palindromic-substring

// class Solution {
//     public String longestPalindrome(String s) {

//         String ans = "";
        
//         for(int i=s.length(); i>=0; i--){
//             for(int j=0; j<i; j++){

//                 if(i-j < ans.length())
//                     break;
                
//                 if(isPalindrome(s.substring(j, i))){
//                     ans = s.substring(j,i);
//                 }
//             }
//         }
        
//         return ans;
        
//     }
    
//     private boolean isPalindrome(String s){
//         int st=0, ed=s.length()-1;
//         while(st<ed){
//             if(s.charAt(st++)!=s.charAt(ed--))
//                 return false;
//         }
//         return true;
//     }
// }

 public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }
    
    private String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j);
    }