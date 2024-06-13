// https://leetcode.com/problems/text-justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        
        int len = words.length;
        
        List<List<String>> lines = new ArrayList<>();
        int st = 0;
        while(st<len){
            
            int wLen = 0;
            
            List<String> list = new ArrayList<>();
            for(int i=st; i<len; i++){
                if(wLen!=0)
                    wLen++;
                wLen += words[i].length();
                list.add(words[i]);
                if(i+1<len && wLen+words[i+1].length()+1 >maxWidth){
                    st = i+1;
                    break;
                }
                st = i+1;
            }
            lines.add(list);
            
            System.out.println(lines);
            
        }
        
        
        for(int i=0; i<lines.size()-1; i++){
            List<String> list = lines.get(i);
            
            int wLen = 0;
            for(String w: list)
                wLen+=w.length();
            
            int space = maxWidth-wLen;
            int slot = list.size()-1;
            StringBuilder sb = new StringBuilder();
            
            if(slot==0){
                sb.append(list.get(0));
                appendSpace(sb, space);
                
            }else{
                for(String w: list){
                    if(!sb.isEmpty()){
                        appendSpace(sb, space/slot);

                        if(space%slot>0){
                            appendSpace(sb, 1);
                            space--;
                        }
                    }
                    sb.append(w);
                }
            }
            
            res.add(sb.toString());
        }
        
        
        // the last row
        List<String> last = lines.get(lines.size()-1);
        StringBuilder sb = new StringBuilder();
        for(String w : last){
            if(!sb.isEmpty()){
                sb.append(" ");
            }
            sb.append(w);
        }
        
        int space = maxWidth-sb.length();
        appendSpace(sb, space);
        res.add(sb.toString());
        
        
        return res;
        
        
        
        
        
        
        
        
    }
    
    
    private void appendSpace(StringBuilder sb, int cnt){
        for(int i=0; i<cnt; i++){
            sb.append(" ");
        }
    }
}