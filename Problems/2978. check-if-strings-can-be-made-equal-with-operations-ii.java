// https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii

class Solution {
    public boolean checkStrings(String s1, String s2) {
                
        
        int len = s1.length();
        int[] arrOdd = new int[26];
        int[] arrEven = new int[26];
        
        for(int i=0;i<len; i++){
            if(i%2==0){
                arrEven[s1.charAt(i)-'a']++;
                arrEven[s2.charAt(i)-'a']--;
            }else{
                arrOdd[s1.charAt(i)-'a']++;
                arrOdd[s2.charAt(i)-'a']--;
            }
                
            
                
        }
        
        for(int i=0; i<26; i++){
            
            // System.out.println(i + " " +arrOdd[i] + " "+ arrEven[i]);
            if(arrOdd[i]!=0 || arrEven[i]!=0)
                return false;
        }
        
        return true;
    }
    // even a++ c-- c++ b-- b++ a--
    // odd. b++ a-- d++ d-- a++ b--;
    
}