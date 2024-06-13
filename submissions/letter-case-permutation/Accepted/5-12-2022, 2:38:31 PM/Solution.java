// https://leetcode.com/problems/letter-case-permutation

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        
        if(s.length()==0)
            return ans;
        
        // System.out.println(Character.charAt(91));
        
        ans.add("");
        for(char c : s.toCharArray()){
            
            List<String> res = new ArrayList<String>();
        
            boolean isAlphabet = (c-'a'<=25 && c-'a'>=0) || (c-'A'<=25 && c-'A'>=0);
            
         
            
            
            for(String a : ans){
                if(isAlphabet){
                    res.add(a + Character.toUpperCase(c));
                    res.add(a + Character.toLowerCase(c));
                }else{
                    res.add(a+c);
                }
            }
            
            ans = res;
        }
        
        return ans;
        
    }
}