// https://leetcode.com/problems/longest-happy-prefix

class Solution {
    public String longestPrefix(String s) {

        int len = s.length();
        int[] next = new int[len];

        /*
        b a b b b
          j   i
        0 0 1

        max = 1, res = b    
        */
        String res = "";
        int max = 0;
        for(int j=0, i=1; i<len; i++){
            while(j>0 && s.charAt(j)!=s.charAt(i)){
                j = next[j-1];
            }

            if(s.charAt(j)==s.charAt(i))
                j++;

            
            next[i]=j;

        }

      
        // 回傳next[len-1]的substr
        res = s.substring(len-next[len-1], len);

        return res;
        
    }
}