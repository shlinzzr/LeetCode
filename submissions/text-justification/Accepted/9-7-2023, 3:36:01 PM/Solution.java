// https://leetcode.com/problems/text-justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        // 先把同一列的word歸類好
        // 獨立出來appendSpace
        // slot==0 特殊處裡
        // 最後一行 特殊處理
        
        
        int len = words.length;
        List<List<String>> list = new ArrayList<>();
        
        int i=0;
        while(i<len){
            
            List<String> row = new ArrayList<>();
            int rowLen = 0;
            
            while(i<len && rowLen + words[i].length()<=maxWidth){
                String w = words[i];
                rowLen += w.length()+1;
                row.add(w);
                i++;
            }
            
            list.add(row);
        }
        
        
        List<String> res = new ArrayList<>();
        
        for(int j=0; j<list.size()-1; j++){
            List<String> row = list.get(j);
            
            int slot = row.size()-1;
            int sLen = 0;
            for(String r : row){
                sLen += r.length();
            }
            int space = maxWidth-sLen;
            
            StringBuilder sb = new StringBuilder();            
            if(slot==0){
                sb.append(row.get(0));
                while(space-->0)
                    sb.append(" ");
                
                res.add(sb.toString());
                continue;
                
            }else{
                
                for(String r: row){
                    
                    if(!sb.isEmpty()){
                        int blank = space/slot + (space%slot>0 ? 1 : 0);
                        space--;
                        while(blank-->0)
                            sb.append(" ");
                    }
                    sb.append(r);
                }
                res.add(sb.toString());
            }
        }
        
        
        List<String> lastRow = list.get(list.size()-1);
        int slot = lastRow.size()-1;
        int sLen = 0;
        for(String r : lastRow){
            sLen += r.length();
        }
        int space = maxWidth-sLen;
        
        StringBuilder sb = new StringBuilder();    
        if(slot==0){
            sb.append(lastRow.get(0));
            while(space-->0)
                sb.append(" ");

            res.add(sb.toString());
        }else{
             for(String r: lastRow){
                if(!sb.isEmpty()){
                    sb.append(" ");
                }
                sb.append(r);
            }
            
            while(sb.length()<maxWidth){
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        
        
        return res;
        
        
        
        
    }
}