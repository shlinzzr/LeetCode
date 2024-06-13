// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] arr = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        
        List<String> res = new ArrayList<>();
          res.add("");
        
        int len = digits.length();
        
        for(int i=0; i<len; i++){
            char ch = digits.charAt(i);
            res = helper(res, arr[ch-'1']);
        }
        
        
        return res;
        
      
    }
    
    
//     private List<String> helper(List<String> res, String str){
        
//         System.out.println(str);
        
//         List<String> tmp = new ArrayList<>();
        
//         for(int i=0; i<str.length(); i++){
//             char ch = str.charAt(i);
            
//             if(res.size()==0){
//                 tmp.add(String.valueOf(ch));
//             }else{
                
//                 for(String r : res){
//                     tmp.add(r+ch);
//                 }
//             }
//             res=new ArrayList<>(tmp);
            
//         }
        
//         return res;
        
//     }
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