// https://leetcode.com/problems/letter-case-permutation

class Solution {
//     public List<String> letterCasePermutation(String s) {
//         List<String> ans = new ArrayList<String>();
        
//         if(s.length()==0)
//             return ans;
        
//         // System.out.println(Character.charAt(91));
        
//         ans.add("");
//         for(char c : s.toCharArray()){
            
//             List<String> res = new ArrayList<String>();
        
//             boolean isAlphabet = (c-'a'<=25 && c-'a'>=0) || (c-'A'<=25 && c-'A'>=0);
            
         
            
            
//             for(String a : ans){
//                 if(isAlphabet){
//                     res.add(a + Character.toUpperCase(c));
//                     res.add(a + Character.toLowerCase(c));
//                 }else{
//                     res.add(a+c);
//                 }
//             }
            
//             ans = res;
//         }
        
//         return ans;
        
//     }
// }

 class Solution {
    /*
        a1b2
        A1b2
        a1B2
        A1B2
        
        [ 'a', '1', 'b', '2' ]
    */
    List<String> list = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        helper(s.toCharArray(), 0);
        return list;
    }
    
    private void helper(char[] s, int i) {
        if (i == s.length) {
            list.add(String.valueOf(s));
            return;
        }
        
        char c = s[i];
        if (Character.isLetter(c) == true) {
            s[i] = Character.toLowerCase(c);
            helper(s, i + 1);
            s[i] = Character.toUpperCase(c);
            helper(s, i + 1);
        } else helper(s, i + 1);
    }
}