// https://leetcode.com/problems/interleaving-string

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length() + s2.length() != s3.length())
             return false;
        
        Boolean[][] table = new Boolean[s1.length()+1][s2.length()+1];
        
        
        for(int i=0; i<s1.length()+1; i++){
            for(int j=0; j<s2.length()+1; j++){
                
                if(i==0&&j==0)
                    table[i][j]=true;
                else if(i==0){
                    table[0][j] = table[0][j-1]  && s2.charAt(j-1)==s3.charAt(j-1);
                        
                }else if(j==0){
                    table[i][0] = table[i-1][0]  && s1.charAt(i-1)==s3.charAt(i-1);
                    
                }else{
                    table[i][j] = (s3.charAt(i+j-1)==s2.charAt(j-1) && table[i][j-1]) || (table[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1));
                }
                
            }
        }
        
        return table[s1.length()][s1.length()];
        
        
        
//         int i1=0, i2=0;
        
//         HashSet<int> checkpt = new HashSet<>();
         
        
//         for(int i=0; i<s3.length; i++){
            
//             char c  = s3.charAt(i);
            
//             if(  (i1<s1.length() && c==s1.charAt(i1)) && (i2<s2.length() && c==s2.charAt(i2))  )
//                 checkpt.
            
//             if(i1<s1.length() && c==s1.charAt(i1)){
//                 i1++;
//             }else if(i2<s2.length() && c==s2.charAt(i2)){
//                 i2++;
//             }else
//                 return false;
            
            
//         }
        
//         return true;
        
        
    }
}