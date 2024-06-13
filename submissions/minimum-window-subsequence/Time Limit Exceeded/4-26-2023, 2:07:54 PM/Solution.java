// https://leetcode.com/problems/minimum-window-subsequence

class Solution {
    public String minWindow(String s1, String s2) {
       
        int[] arr  = new int[26];
        for(char ch : s2.toCharArray()){
            arr[ch-'a']++;
        }
        
        String str = "";
        int min = s1.length();
        int[] tmp = new int[26];
        int st=0;
        for(int ed=0; ed<s1.length(); ed++){
            
            char ch = s1.charAt(ed);
            tmp[ch-'a']++;
            
//             if(!ok(arr, tmp, s1.substring(st, ed+1), s2))
//                 continue;
            
            while(ok(arr, tmp, s1.substring(st, ed+1), s2) && st<=ed){
                
                if(ed-st+1<min){
                    min = ed-st+1;
                    str = s1.substring(st, ed+1);
                }
                
                tmp[s1.charAt(st++)-'a']--;
            }
        }
        
        return str;
        
        
        
        
    }
    
    private boolean ok(int[] arr , int[] tmp, String curr, String s2){
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]>tmp[i])
                return false;
        }
        
        
        int idx=0;
        for(int i=0; i<curr.length(); i++){
            if(curr.charAt(i)==s2.charAt(idx))
                idx++;
        }
        
        
        return idx==s2.length();
    } 
}