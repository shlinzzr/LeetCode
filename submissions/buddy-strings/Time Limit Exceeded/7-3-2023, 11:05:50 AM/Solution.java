// https://leetcode.com/problems/buddy-strings

class Solution {
    public boolean buddyStrings(String s, String goal) {
        int len = s.length();
        
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                
                char[] arr = s.toCharArray();
                char t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                
                if(new String(arr).equals(goal))
                    return true;
                
            }
        }
        
        return false;
    }
}