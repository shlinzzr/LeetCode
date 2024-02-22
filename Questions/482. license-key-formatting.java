// https://leetcode.com/problems/license-key-formatting

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        
        
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(s.charAt(i)!='-'){
                ch = Character.toUpperCase(ch);
                sb.append(ch);
            }
        }
        
        System.out.println(sb.toString());
        
        StringBuilder res = new StringBuilder();
        
        for(int i=sb.length()-1; i>=0; i--){

            char ch = sb.charAt(i);
            
            if(ch!='-'){
                res.insert(0, ch);
                cnt++;
            }
            
            if(cnt%k==0 && i!=0)
                res.insert(0, "-");
            
        }
        return res.toString();
    }
}