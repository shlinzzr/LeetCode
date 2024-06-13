// https://leetcode.com/problems/to-lower-case

class Solution {
    public String toLowerCase(String s) {
//         char a = 'a';
//         char A = 'A';
        
//         System.out.println((int) A);
//         return "";
        
//         // a 97
//         // A 65
        
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
             if(c>='A' && c<='Z')
                 arr[i] = (char) (c-'A'+'a');
            
            
        }
        
        return String.valueOf(arr);
        
        
        
        
        
//         String res = "";
//         for(char c : s.toCharArray()){
            
//             if(c>='A' && c<='Z')
//                 res +=  (char) (c-'A'+'a');
//             else 
//                 res += c;
//         }
        
//         return res;
        
    }
}