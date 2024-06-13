// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        int len = s.length();
        int[] arr = new int[26];
        for(int i=0; i<len; i++){
            arr[s.charAt(i)-'a']++;
        }
        
        for(int i=0; i<26; i++){
            int cnt = arr[i];
            if(cnt!=0 && len%cnt!=0) return false;
        }
        
        for(int i=1; i<=len/2 ;i++){
            
            if(len%i!=0) continue;
            
            String sub = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            int loop = len/i;
            for(int j=0; j<loop; j++){
                sb.append(sub);
            }
            if(s.equals(sb.toString())) return true;
        }
        
        return false;
        
        
    }
}