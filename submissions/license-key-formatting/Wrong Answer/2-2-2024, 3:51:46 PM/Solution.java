// https://leetcode.com/problems/license-key-formatting

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        
        
        int cnt = 0;
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]=='-') continue;
            
            if(arr[i]>='a' && arr[i]<='z'){
                arr[i] = (char)((int)(arr[i]-'a')+'A');
            }
            
            sb.insert(0, arr[i]);
            cnt++;
            if(cnt%4==0){
                sb.insert(0, '-');
            }
            
        }
        
        if(!sb.isEmpty() && sb.charAt(0) =='-')
            sb.deleteCharAt(0);
        
        return sb.toString();
        
    }
}