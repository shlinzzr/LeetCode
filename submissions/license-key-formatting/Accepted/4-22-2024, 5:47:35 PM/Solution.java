// https://leetcode.com/problems/license-key-formatting

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int len = s.length();
        
        // "azAZ09-"
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=len-1; i>=0; i--){
            if(s.charAt(i)=='-') continue;
            if(!sb.isEmpty() && (sb.length()+1)% (k+1)==0){
                sb.append("-");
            }
            
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                int idx = ch-'a';
                ch = (char)('A'+idx);
            }
            sb.append(ch);
        }
        
        return sb.reverse().toString();
    }
}