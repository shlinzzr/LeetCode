// https://leetcode.com/problems/sentence-screen-fitting

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
        
        for(String w : sentence){
            if(w.length()>cols)
                return 0;
        }
        
        
        int res =0 ;
        
        int len = sentence.length;
        int idx = 0;
        int r=0;
        
        while(r<rows){
            
            StringBuilder sb = new StringBuilder();
            int space = cols;
            boolean bool = true;
            
            while( (sb.isEmpty() ? sentence[idx%len].length()<=space : sentence[idx%len].length()+1<=space)){
                
                if(!sb.isEmpty()){
                    sb.append(" ");
                }
                    
                
                sb.append(sentence[idx++%len]);
                space = cols-sb.length();
                if(idx%len==0)
                    res++;
            }
            r++;
        }
        
        return res;
        
        
        
    }
}