// https://leetcode.com/problems/sentence-screen-fitting

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
        String s = "";
        for(String w : sentence){
            if(w.length()>cols)
                return 0;
            
            s += w + " ";
        }
        
        // rows = 2, cols = 8
        //      012345678
        // s = "hello world ", len=11
        //           ^<-^
        
        // s.charAt(8)!=' '
        
        int len = s.length();
        
        int idx =0;
        for(int r=0; r<rows; r++){
            idx+=cols;
            while(s.charAt(idx%len)!=' '){
                idx--;
            }
            
            idx++;
        }
        
        return idx/len;
        
        
        
        // use as 68. Text Justification => TLE
//         for(String w : sentence){
//             if(w.length()>cols)
//                 return 0;
//         }
        
//         int res =0 ;
//         int len = sentence.length;
//         int idx = 0;
//         int r=0;
        
//         while(r<rows){
            
//             StringBuilder sb = new StringBuilder();
//             int space = cols;
//             boolean bool = true;
            
//             while( (sb.isEmpty() ? sentence[idx%len].length()<=space : sentence[idx%len].length()+1<=space)){
                
//                 if(!sb.isEmpty()){
//                     sb.append(" ");
//                 }
                    
                
//                 sb.append(sentence[idx++%len]);
//                 space = cols-sb.length();
//                 if(idx%len==0)
//                     res++;
//             }
//             r++;
//         }
        
//         return res;
        
        
        
    }
}