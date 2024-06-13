// https://leetcode.com/problems/take-k-of-each-character-from-left-and-right

class Solution {
    public int takeCharacters(String s, int k) {
        
        int len = s.length();
        
        if(len<3*k)
            return -1;
        
        int[]arr = new int[3];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        
        int[] tmp = new int[3];
        int min = len;
        
        int st =0; 
        for(int ed=0; ed<len; ed++){
            char ch = s.charAt(ed);
            
            tmp[ch-'a']++;
            
            while(arr[ch-'a']-tmp[ch-'a']<k && st<=ed){
                tmp[s.charAt(st++)-'a']--;
            }
            
            min = Math.min(min ,len-(ed-st+1));
        }
        
        return min;
        
        
        
        
    }
    
    private boolean ok(int[] arr, int k, int[] tmp){
        
        for(int a: arr){
            if(a<k)
                return false;
        }
        return true;
        
    }
}