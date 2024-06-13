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
                }else
                    break;
            }
        }

        return res;
   }  
}

// siz : 5 6 7 8
// g : 7 8 9 10