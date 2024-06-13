// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {

        
        
        String[] dict = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "*", "#"};
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
        
        
        helper(res, new StringBuilder(), dict, 0, digits);
        return res;
    }
    
    
    private void helper(List<String> res, StringBuilder cur, String[] dict, int idx, String digits){
        
        if(cur.length()==digits.length()){
            res.add(cur.toString());
            return;
        }
        
        String ds = dict[digits.charAt(idx)-'0'];
        
        for(char c : ds.toCharArray()){
            cur.append(c);
            helper(res, cur, dict, idx+1, digits);
            cur.deleteCharAt(cur.length() - 1);
        }
        
        return;
        
        
        
    }
}