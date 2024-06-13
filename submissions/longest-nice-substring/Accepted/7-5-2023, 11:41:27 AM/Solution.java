// https://leetcode.com/problems/longest-nice-substring

class Solution {
    public String longestNiceSubstring(String s) {
        int len = s.length();
        
        int max= 0;
        int st=0;
        String res = "";
        
        
        for(int i=0; i<len-1; i++){
            
            
            int[] arr = new int[52];    
            
            for(int j=i; j<len; j++){
                
                 char ch = s.charAt(j);
            
                if(ch>='a'&& ch <='z')
                    arr[ch-'a']++;
                else 
                    arr[ch-'A'+26]++;
                
                if(isOk(arr) && j-i+1>max){
                
                    max= Math.max(max, j-i+1);

                    res = s.substring(i, j+1);
                }
            }
            
        }
        
        
        return res;
        
        
        
//         for(int ed=0; ed<len; ed++){
            
//             char ch = s.charAt(ed);
            
//             if(ch>='a'&& ch <='z')
//                 arr[ch-'a']++;
//             else 
//                 arr[ch-'A'+26]++;
            
//             while(isOk(arr)==false){
                
//                 char chh = s.charAt(st);
            
//                 if(chh>='a'&& chh <='z')
//                     arr[chh-'a']--;
//                 else 
//                     arr[chh-'A'+26]--;
                
//                 st++;
//             }
            
            
//             if(ed-st+1>max){
                
//                 max= Math.max(max, ed-st+1);
                
//                 res = s.substring(st, ed+1);
//             }
            
            
            
//         }
        
//         return res;
    }
    
    
    private boolean isOk(int[] arr){
        
        for(int i=0; i<26; i++){
            
            if((arr[i]!=0 && arr[i+26]==0) || (arr[i]==0 && arr[i+26]!=0))
               return false;
        }
               
               return true;
    }
}