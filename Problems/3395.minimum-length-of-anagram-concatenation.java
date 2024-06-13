// https://leetcode.com/problems/minimum-length-of-anagram-concatenation

class Solution {
    public int minAnagramLength(String s) {
        
        
        
        for(int m=1; m<=s.length(); m++){
            
            
            
            if(s.length()%m!=0) continue;
            
              int[] arr = new int[26];
            
            for(int i=0; i<m; i++){
                arr[s.charAt(i)-'a']++;
            }
            
            
            
            
            
            boolean mflag = true;
            
            for(int i=0; i<s.length(); i+=m){
                
                int[] tmp = new int[26];
                
                for(int j=i; j<i+m&&j<s.length(); j++){
                    
                    char ch = s.charAt(j);
                    tmp[ch-'a']++;
                    if(tmp[ch-'a']>arr[ch-'a']) break;
                }
                
                boolean rt = check(arr, tmp);
                // System.out.println(m+ " " + i + " " + rt);
                if(rt==false){
                    mflag = false;
                    break;
                }
                
            }
            
            if(mflag){
                return m;
            }
           
            
            
        }
        
        return s.length();
        
    }
    
    
    private boolean check(int[] arr, int[] tmp){
        
        for(int i=0; i<26; i++){
            if(arr[i]!=tmp[i]) return false;
        }
        
        return true;
    }
}