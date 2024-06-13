// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] arr = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        
        int len = digits.length();
        
        List<String> res = new ArrayList<>();
        res.add("");
           // System.out.println("len="+len);
        
        for(int i=0; i<len; i++){
            
            char ch = digits.charAt(i);
            int idx = ch-'0';
            
               // System.out.println("idx="+idx);
            
            String str = arr[idx-1];
            
            res = helper(res, str);
        }
        
        
        if(res.size()==1 && res.get(0)=="")
            return new ArrayList<>();
        
        return res;
    }
    
    
    private List<String> helper(List<String> res, String str){
        
         // for(String r: res)
         //    System.out.println("r="+r);
        
        List<String> tmp = new ArrayList<>();
        for(int i=0; i<str.length(); i++){   //'def'
           
            for(int j=0; j<res.size(); j++){ // 'a', 'b', 'c'
                
                // System.out.println(res.get(j)+str.charAt(i));
                
                tmp.add(res.get(j)+str.charAt(i));
            }
            
        }
        res = new ArrayList<>(tmp);
        return res;
       
        
    }
}