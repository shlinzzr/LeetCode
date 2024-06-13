// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    
    String[] arr = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        
        if(!digits.isEmpty())
            curr.add("");
        
        helper(digits, res, curr, 0);
        
        return res;
    }
    
    private void helper(String digits,  List<String> res,  List<String> curr, int idx){
        
        if(idx==digits.length()){
            
            for(String cur : curr){
                res.add(cur);
            }
            return;
        }
        
        char n = digits.charAt(idx);
        String can = arr[n-'1'];
        
        
        List<String> tmp = new ArrayList<>();
        for(char ch : can.toCharArray()){
            
            for(String cur : curr){
                tmp.add(cur + ch);
            }
        }
        
        helper(digits, res, tmp, idx+1);
        
        
        
    }

}