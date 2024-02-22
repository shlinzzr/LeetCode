// https://leetcode.com/problems/buddy-strings

class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if(s.length()!=goal.length())
            return false;
        
        int diff=0;
        int idx1 = -1, idx2=-1;
        
        int[] arr = new int[26];
        
        for(int i=0; i<s.length(); i++){
            
            arr[s.charAt(i)-'a']++;
            
            if(s.charAt(i)!=goal.charAt(i)){
                
                diff++;
                if(diff>2)
                    return false;
                
                if(idx1==-1)
                    idx1=i;
                else
                    idx2=i;
            }
        }
        
        if(diff==0){
            for(int a : arr){
                if(a>1)
                    return true;
            }
            return false;
        }
        
        
        
        if(diff!=2)
            return false;
        
        char[] ar = s.toCharArray();
        char t = ar[idx1];
        ar[idx1] = ar[idx2];
        ar[idx2] = t;
        
         if(new String(ar).equals(goal))
            return true;
        
        return false;
        
    }
}