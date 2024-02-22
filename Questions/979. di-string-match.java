// https://leetcode.com/problems/di-string-match

class Solution {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length()+1];
        
        int st=0, ed=s.length();
        
       for(int i=0; i<res.length;i++){
           
           if(i==res.length-1)
               res[i] = st;
           
            else if(s.charAt(i)=='I'){
                res[i] = st++;
            }
                
           else {
               res[i] = ed--;
           }
               
        }
        
        
        return res;
    }
}