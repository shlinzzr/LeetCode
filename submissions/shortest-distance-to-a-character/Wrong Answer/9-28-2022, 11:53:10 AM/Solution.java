// https://leetcode.com/problems/shortest-distance-to-a-character

class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        int len = s.length();
        
        for(int i=0; i<len; i++){
                
            if(i==0){
                res[i] =s.indexOf(c);    
            }else{
                res[i] = Math.min(res[i-1]+1, s.indexOf(c, i)-i);
            }
            
        }
        
        
        for(int r : res){
            System.out.print(r + ", ");
        }
        
        return res;
    }
}