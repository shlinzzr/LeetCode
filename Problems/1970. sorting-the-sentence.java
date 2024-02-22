// https://leetcode.com/problems/sorting-the-sentence

class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        
        
       String[] tmp = new String[arr.length]; 
        for(String str : arr){
            int idx = Integer.valueOf(str.substring(str.length()-1, str.length()));
            
            // System.out.println(str);
            
            tmp[idx-1] = str.substring(0, str.length()-1);
            
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for(String str : tmp){
            if(sb.toString().length()!=0)
                sb.append(" ");
            sb.append(str);
            
        }
        
        return sb.toString();
        
        
        
        
    }
}