// https://leetcode.com/problems/split-strings-by-separator

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char ch) {
        List<String> res = new ArrayList<>();
        
        for(String w : words){
            
            String str = ch + "";
            if(ch=='.')
                str = "\\.";
            
             if(ch=='|')
                str = "\\|";
            
             if(ch=='$')
                str = "\\$";
                
                
            String[] arr = w.split(str);
            for(String a : arr){
                if(a.equals(""))
                    continue;
                
                res.add(a);
                
            }
            
          
            
        }
        
          return res;
    }
}