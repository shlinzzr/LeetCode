// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        
        if(s1.equals(s2))
            return true;
        
        int len = s1.length();
        int cnt=0;
        
        int[] arr = new int [26];
        for(int i=0; i<len; i++){
            if(s1.charAt(i)!=s2.charAt(i))
                cnt++;
            
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        
        return cnt==2 ? true : false;
        
            
    }
}