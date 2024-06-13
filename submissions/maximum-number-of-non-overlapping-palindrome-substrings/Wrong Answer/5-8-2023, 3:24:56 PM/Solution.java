// https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings

class Solution {
    public int maxPalindromes(String s, int k) {
        
        int n = s.length();
        
        int cnt=0;
        
        for(int i=0; i<n; i++){
            
            for(int j=i+k; j<=n; j++){
                    
                
                int len = j-i;
                
                // if(len>k+1)break;
                
                if(isPal(s.substring(i, j))){
                    cnt++;
                    i=j-1;
                    break;
                }
                    
            }
        }
        
        return cnt;
        
    }
    
    //  boolean isPal(String s, int l, int r) {
    //     while (l < r) {
    //         if (s.charAt(l++) != s.charAt(r--)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    private boolean isPal(String s){
         // System.out.println(s);
        int len = s.length();
        
        int st=0, ed=len-1;
        
        while(st<ed){
            
            if(s.charAt(st)==s.charAt(ed)){
                st++;
                ed--;
            }else{
                return false;
            }
            
        }
        System.out.println(s);
        return true;
        
        
    }
    
    
    
    
    
//     class Solution {

//     public int maxPalindromes(String s, int k) {
//         int ans = 0;

//         for (int i = 0; i < s.length(); i++) {
//             for (int j = i; j < s.length(); j++) {
//                 int len = (j - i) + 1;
//                 if (len > k + 1) break;

//                 if (len >= k && isPalindrome(s, i, j)) {
//                     ans++;
//                     i = j;
//                     break;
//                 }
//             }
//         }
        
//         return ans;
//     }

//     boolean isPalindrome(String s, int l, int r) {
//         while (l < r) {
//             if (s.charAt(l++) != s.charAt(r--)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

}