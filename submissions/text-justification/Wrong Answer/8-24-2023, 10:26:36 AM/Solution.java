// https://leetcode.com/problems/text-justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String w : words){
            if(!sb.isEmpty())
                sb.append(" ");
            sb.append(w);
        }
        sb.append(" ");
        
        for(int i =0; i<sb.length(); i++){
            
            int end = maxWidth-1<sb.length()? maxWidth-1 : sb.length()-1;
            while(sb.charAt(end)!=' '){
                end--;
            }
            i=0;
            
            // System.out.println(end);
            
            if(end==sb.length()-1){
                while(end<maxWidth-1){
                    sb.append(" ");
                    end++;
                }
                res.add(sb.toString());
                break;
                
            }else{
                String sub = sb.substring(0, end);
                sb.delete(0, end+1);
                sub = insertSpace(sub, maxWidth);
                res.add( sub);
            }
            
            // System.out.println(sb.toString());
        }
        
        return res;
    }
    
    private String insertSpace(String s, int maxWidth){
        
        int space = maxWidth-s.length();
        
        int slot = 0;
        for(char ch : s.toCharArray()){
            if(ch==' ')
                slot++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch==' '){
                
                for(int i=0; i<1+space/slot; i++)
                    sb.append(" ");
                
                if(space%slot>0){
                    sb.append(' ');
                    space--;
                }
                
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
         
        
        
    }
}