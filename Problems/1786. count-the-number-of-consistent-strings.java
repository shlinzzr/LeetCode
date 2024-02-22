// https://leetcode.com/problems/count-the-number-of-consistent-strings

class Solution {
//     public int countConsistentStrings(String allowed, String[] words) {
        
//         char[] arr = allowed.toCharArray();
//         int cnt=0;
//         for(String w : words){
            
//             boolean contain=true;
//             for(char a : arr){
//                 w = w.replaceAll(""+a, "");
//             }
            
//             if(w.isEmpty())
//                 cnt++;
            
//         }
        
//         return cnt;
        
//     }
    public int countConsistentStrings(String allowed, String[] words) {
        int [] alpha = new int[26];
        
        for (int i=0; i < allowed.length(); i++)
        {
            char ch = allowed.charAt(i);
            alpha[ch-'a']++;
        }
        
        int count = 0;
        
       
        
        for (String word : words)
        {   
             boolean con = true;
            
            for (int i=0; i < word.length(); i++)
            {
                char ch = word.charAt(i);
                if (alpha[ch-'a'] <= 0){
                    con = false;
                    break;
                }
                
            }
            if(con)
                count++;
        }
        
        return count;
    }
}