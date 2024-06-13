// https://leetcode.com/problems/find-smallest-letter-greater-than-target

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        
        int st=0, ed = len-1;
        
        while(st<ed){
            
            
            int mid = st+(ed-st)+1/2;
            
            if(letters[mid]>=target){
                ed = mid-1;
            }else{
                st = mid;
            }
        }
        
        if(st<len-1 && letters[st+1]==target)
            return letters[st];
        
        return letters[0];
    }
}