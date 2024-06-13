// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    
    List<String> ret;
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        String[] dict = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        
        
        List<String> curr = new ArrayList<>();
        curr.add("");
        
        int len = digits.length();
        if(len==0)
            return res;
        
        helper(digits, 0, curr, dict);
        
        return ret;
        
    }
    
    
    private void helper(String digits, int st, List<String> curr, String[] dict){
        
        int len = digits.length();
        if(st==digits.length()){
            return;
        }
        
            
        int idx = digits.charAt(st)-'0';
        
        List<String> temp = new ArrayList<>();
        
        
        for(String cur : curr){
            for(char ch : dict[idx].toCharArray()){
                
                System.out.println(cur+ch);
                
                temp.add(cur+ch);
            }
        }
        ret = temp;
        curr = temp;
        
        helper(digits, st+1, curr, dict);
            
            
        
        
        
        
            
        
    }
}