// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    
    String[] dict = new String[]{"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
    
    public List<String> letterCombinations(String digits) {
        
        String cur = "";
        
        List<String> res = new ArrayList<>();
        
        helper(digits, 0, res, new StringBuilder());
        
        return res;
        
    }
    
    private void helper(String digits, int idx, List<String> res, StringBuilder sb){
        
        if(idx==digits.length()){
            res.add(sb.toString());
            return;
        }
        
        // for(int i=idx; i<digits.length(); i++){
            
            char num = digits.charAt(idx);
            String w = dict[num-'0'];
            
            for(int j=0; j<w.length(); j++){
                char ch = w.charAt(j);
                sb.append(ch);
                helper(digits, idx+1, res, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        // }
        
    }
}