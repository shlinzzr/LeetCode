// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] arr = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        
        List<String> res = new ArrayList<>();
        res.add(""); // for first iteration
        
        int len = digits.length();
        
        for(int i=0; i<len; i++){
            char ch = digits.charAt(i);
            res = helper(res, arr[ch-'1']);
        }
           
        if(res.size()==1 && res.get(0)=="")
            return new ArrayList<>();
        
        return res;
        
      
    }
    
     private List<String> helper(List<String> res, String str){
        
        List<String> tmp = new ArrayList<>();
        for(int i=0; i<str.length(); i++){   //'def'
           
            for(int j=0; j<res.size(); j++){ // 'a', 'b', 'c'
                tmp.add(res.get(j)+str.charAt(i));
            }
            
        }
        res = new ArrayList<>(tmp);
        return res;
       
        
    }
}