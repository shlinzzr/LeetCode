// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {

        
        
        String[] dict = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "*", "#"};
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
        
        
        helper(res, "", dict, 0, digits);
        return res;
    }
    
    
    private void helper(List<String> res, String cur, String[] dict, int idx, String digits){
        
        if(cur.length()==digits.length()){
            res.add(cur);
            return;
        }
        
        String ds = dict[digits.charAt(idx)-'0'];
        
        for(char c : ds.toCharArray()){
            helper(res, cur+c, dict, idx+1, digits);
        }
        
        return;
        
        
        
    }
}