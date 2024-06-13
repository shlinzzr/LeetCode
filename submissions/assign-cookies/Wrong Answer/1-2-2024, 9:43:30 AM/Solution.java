// https://leetcode.com/problems/assign-cookies

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;

        int j=0;
        for(int i=0; i<s.length; i++){

            for(; j<g.length; j++){

                if(s[i]>= g[j]){
                    res+=1;
                    j++;
                    break;
                }
            }
        }

        return res;
   }  
}