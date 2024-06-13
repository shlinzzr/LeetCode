// https://leetcode.com/problems/text-justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        int len = words.length;
        
        
        int idx = 0;
        while(idx<len){
            
            StringBuilder sb = new StringBuilder(); 
            String w = words[idx];
            int space = maxWidth;
            boolean first = true;
            
            List<Integer> list = new ArrayList<>();
            while(first || w.length()+1<=space){
                
                if(first)
                    first = false;
                else {
                    sb.append(" ");
                    list.add(sb.length());
                }
                
                sb.append(w);
                
                // System.out.println(idx + " w=" + w + " space="+space + " sb="+sb.toString());
                space = maxWidth-sb.length();
                idx++;
                
                
                if(idx==len)
                    break;
                
                w = words[idx];
                
            }
//              System.out.println("end loop");
            System.out.println(idx + " w=" + w + " space="+space + " sb="+sb.toString());
                
            
            if(idx==len){
                insertSpace(sb, space, true);
                res.add(sb.toString());
                break;
            }
            
            insertSpace(sb, space, false);
            
            res.add(sb.toString());
            // System.out.println("res="+res.toString());
        }
        
        return res;
        
        
        
    }
    
    private StringBuilder insertSpace(StringBuilder sb, int space, boolean last){
        
        if(space==0)
            return sb;
        
        if(last || sb.indexOf(" ")==-1){
            while(space-->0){
                sb.append(" ");
            }
            
            return sb;
        }
        
        
        int idx = sb.indexOf(" ");
        while(space-->0){
            if(idx==-1)
                idx = sb.indexOf(" ");
            
            sb.insert(idx, " ");
            idx = sb.indexOf(" ", idx+3);
            // System.out.println(sb.toString() + " idx=" + idx + " space="+space);
        }
        
        return sb;
        
        
    }
    
}