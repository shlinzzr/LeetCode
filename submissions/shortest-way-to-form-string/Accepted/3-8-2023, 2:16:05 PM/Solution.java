// https://leetcode.com/problems/shortest-way-to-form-string

class Solution {
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        
        boolean[] bool = new boolean[26];
        for (int i = 0; i < cs.length; i++) 
            bool[cs[i] - 'a'] = true;
        
        
        int j = 0, res = 1;
        for (int i = 0; i < ts.length; i++,j++) {
            if (!bool[ts[i] - 'a'])
                return -1;
            
            while (j < cs.length && cs[j] != ts[i]) {
                j++;
            }
            if (j == cs.length) { //reset
                j = -1;
                res++;
                i--;
            }
        }
        return res;
    }
}