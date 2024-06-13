// https://leetcode.com/problems/rearrange-string-k-distance-apart

class Solution {
    public String rearrangeString(String s, int k) {
        char[] arr = new char[26];
        
        
        int max = 0;
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
            max = Math.max(max, arr[ch-'a']);
        }
        
        int cnt = 0;
        int total=0;
        for(int a : arr){
            total+=a;
            if(a==max)
                cnt++;
        }
        
        int len = (max-1)*k+1 + cnt;
        
        if(s.length() <len)
            return "";
        
        
        
        
        
        int curr=0;
        while(curr<total){
            
            for(int )            
            
        }
        
        
        return len<=k;
        
        
        
    }
}