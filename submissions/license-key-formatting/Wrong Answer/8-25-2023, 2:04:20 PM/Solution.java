// https://leetcode.com/problems/license-key-formatting

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        
        
        int cnt = 0;
        for(int i=s.length()-1; i>=0; i--){
            
            char ch = s.charAt(i);
            ch = Character.toUpperCase(ch);
            
            if(s.charAt(i)!='-'){
                sb.insert(0, ch);
                cnt++;
            }else{
                continue;
            }
            
            if(cnt%k==0 && i!=0){
                sb.insert(0, "-");
            }
        }
        
        return sb.toString();
    }
}