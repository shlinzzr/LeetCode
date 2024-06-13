// https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i

class Solution {
    public boolean canBeEqual(String s1, String s2) {
        
        int[] arrOdd = new int[26];
        int[] arrEven = new int[26];
        
        for(int i=0;i<4; i++){
            if(i%2==0){
                arrOdd[s1.charAt(i)-'a']++;
                arrOdd[s2.charAt(i)-'a']--;
            }else{
                arrEven[s1.charAt(i)-'a']++;
                arrEven[s2.charAt(i)-'a']--;
            }
                
            
                
        }
        
        for(int i=0; i<4; i++){
            if(arrOdd[i]!=0 || arrEven[i]!=0)
                return false;
            
        }
        
        return true;
        
    }
}