// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    
     String[] arr = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        List<String> curr= new ArrayList<>();
        curr.add("");
        helper(digits, 0, curr, res);
        res.remove("");
        return res;
        
    }
    
    private void helper(String digits, int d, List<String> curr, List<String> res){
        
        if(d==digits.length()){
            
            for(String c: curr)
                res.add(c);
            return;
        }
        
        char num = digits.charAt(d);
        String word = arr[num-'1'];
        // System.out.println (num + "  " + word);
        
        List<String> tmp = new ArrayList<>();
        for(char ch : word.toCharArray()){
            
            for(String c : curr){
                tmp.add(c+ch);
            }
        }
        
        
        // for(String t: tmp) {
        //     System.out.println(t);
        // }        
        
        helper(digits, d+1, tmp, res);
        
        
        
    }
    
}