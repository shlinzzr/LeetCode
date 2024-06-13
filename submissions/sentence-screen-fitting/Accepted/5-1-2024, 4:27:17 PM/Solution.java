// https://leetcode.com/problems/sentence-screen-fitting

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
        for(String w : sentence){
            if(w.length()>cols)
                return 0;
        }
        
        
        // "i had apple pie "
        //       ^
        // hit char : idx--;
        // hit ' ' idx++
            
         StringBuilder sb = new StringBuilder();
        for(String w : sentence){
            sb.append(w).append(" ");
        }
        int len = sb.length();
        
        int idx =0;
        for(int r=0; r<rows; r++){
            idx+=cols;
            while(sb.charAt(idx%len)!=' '){
                idx--;
            }
            
            idx++;
        }
        
        return idx/len;
        
        
            
//         int res = 0 ;
        
//         int i=0, j=0;
//         int len = sentence.length;
//         int idx = 0;
        
//         StringBuilder sb = new StringBuilder();
//         while(i<rows && j<cols){
            
//             String w = sentence[idx];
            
//             if(j!=0){
//                 j++; // append ' '
//             }
            
//             if(j+w.length()<=cols){
//                 j+=w.length();
//                 if(j==cols){
//                     i++;
//                     j=0;
//                 }

//             }else if(j+w.length() > cols){
//                 i++;
//                 j=0;
//                 continue;
//             }
                    
            
//             if(idx==len-1) res++;
            
//             idx = (idx+1)%len;
//         }
        
//         return res;
        
    }
}