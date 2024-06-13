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
//             System.out.println(idx + " w=" + w + " space="+space + " sb="+sb.toString());
                
            
            if(idx==len){
                while(space>0){
                    sb.append(" ");
                    space--;
                }
                res.add(sb.toString());
                break;
            }
                
            
            
            int ins = sb.indexOf(" ");
            int st =-1;
            while(space>0 && ins!=-1){
                ins = sb.indexOf(" ", st+2);
                if(ins==-1)
                    ins = sb.indexOf(" ", 0);
                
                st = ins;
                sb.insert(ins, " ");
                space--;
            }
            
            while(space>0){
                sb.append(" ");
                space--;
            }
            
            
            
            res.add(sb.toString());
            // System.out.println("res="+res.toString());
        }
        
        return res;
        
        
        
    }
}