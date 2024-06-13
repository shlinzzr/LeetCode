// https://leetcode.com/problems/faulty-keyboard

class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean rev = false;
        
        int idx=0;
        
      for(char ch : s.toCharArray()){
          
          
          if(ch=='i'){
              sb = new StringBuilder(sb.reverse());
              continue;
          }
              
        
          // if(!rev)
              sb.append(ch);
          
          // else{
          //     sb.insert(sb.length()-idx++, ch);
          // }
          
      }
        
        return sb.toString();
    }
        
        
}