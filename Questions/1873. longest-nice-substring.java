// https://leetcode.com/problems/longest-nice-substring


// sol : divide & conqure

class Solution {
    public String longestNiceSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (charSet.contains(Character.toUpperCase(s.charAt(i))) &&
                    charSet.contains(Character.toLowerCase(s.charAt(i)))) {
                continue;
            }
            String s1 = longestNiceSubstring(s.substring(0, i));
            String s2 = longestNiceSubstring(s.substring(i+1));
            return s1.length()>= s2.length() ? s1 : s2;
        }
        return s;
    }
}


// solution brute-force


// class Solution {
//     public String longestNiceSubstring(String s) {
//         int len = s.length();
        
//         int max= 0;
//         int st=0;
//         String res = "";
        
        
//         for(int i=0; i<len-1; i++){
            
            
//             int[] arr = new int[52];    
            
//             for(int j=i; j<len; j++){
                
//                  char ch = s.charAt(j);
            
//                 if(ch>='a'&& ch <='z')
//                     arr[ch-'a']++;
//                 else 
//                     arr[ch-'A'+26]++;
                
//                 if(isOk(arr) && j-i+1>max){
                
//                     max= Math.max(max, j-i+1);

//                     res = s.substring(i, j+1);
//                 }
//             }
            
//         }
        
        
//         return res;
        
        
//     }
    
    
//     private boolean isOk(int[] arr){
        
//         for(int i=0; i<26; i++){
            
//             if((arr[i]!=0 && arr[i+26]==0) || (arr[i]==0 && arr[i+26]!=0))
//                return false;
//         }
               
//                return true;
//     }
// }