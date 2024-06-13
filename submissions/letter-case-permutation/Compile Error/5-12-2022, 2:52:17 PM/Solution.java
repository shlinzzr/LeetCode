// https://leetcode.com/problems/letter-case-permutation

// class Solution {
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

 void recurse(char[] str, int pos, List<String> result) {
        //If we have reached a leaf in the recursion tree, save the result.
        if (pos == str.length) {
            result.add(new String(str));
            return;
        }
        
        //If char is not a letter, no processing required.
        if (Character.isLetter(str[pos])) {
            //If uppercase char, we make it lower case, and recurse.
            if (Character.isUpperCase(str[pos])) {
                str[pos] = Character.toLowerCase(str[pos]);
                
                //Start a new branch in the recursion tree, exploring options that are possible only if we had changed the case.
                recurse(str, pos + 1, result);
                
                //Backtracking. We undo the change so that we can start a new branch in the recursion tree.
                str[pos] = Character.toUpperCase(str[pos]);
            }
            //If lowercase, then we make it upper case, and recurse.
            else {
                str[pos] = Character.toUpperCase(str[pos]);
                recurse(str, pos + 1, result);
                //Backtracking as explained above.
                str[pos] = Character.toLowerCase(str[pos]);
            }
        }
        //This branch explores options that are possible only if the previously performed change (if any) hadn't happened.
        recurse(str, pos + 1,  result);
    }
    
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        recurse(S.toCharArray(), 0, result);
        return result;
    }
}