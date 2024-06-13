// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    
     public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
    
//     public int characterReplacement(String s, int k) {
       
//         if(s.length()==1)
//             return 1;
        
//         int max =0, tmp=k;
//         for(int i=0, j=i+1 ; i<s.length(); i++){
//             tmp=k;
//             j=i+1;
//             while(j<s.length() && (s.charAt(i)==s.charAt(j) || tmp>0)){
              
//                 // System.out.println(i + " " + j + " m=" + max);
                
//                 if(s.charAt(i)!=s.charAt(j)){
//                     tmp--;    
//                 }
//                 j++;
//             }
                
//             int len =  j-i; //j==s.length()-1? j-i+1: j-i;
//             max = Math.max(max, len);
//         }
        
//         String r = new StringBuilder(s).reverse().toString();
//         for(int i=0, j=i+1 ; i<r.length(); i++){
//             tmp=k;
//             j=i+1;
//             while(j<s.length() && (r.charAt(i)==r.charAt(j) || tmp>0)){
              
                
//                 if(r.charAt(i)!=r.charAt(j)){
//                     tmp--;    
//                 }
//                 j++;
//             }
                
//             int len =  j-i; 
            
//             if()
            
//             max = Math.max(max, len);
//         }
        
        
        
        
//         return max;
        
//     }
}