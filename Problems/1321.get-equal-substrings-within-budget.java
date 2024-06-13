// https://leetcode.com/problems/get-equal-substrings-within-budget

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        String org = s;

        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();
        int len = s.length();


        int cost=0;
        int max= 0 ;
        int st= 0 ;
        for(int ed=0; ed<len; ed++){

            int abs = Math.abs(arr_s[ed]-arr_t[ed]);
            cost += abs;
            

            while(cost>maxCost){
                abs = Math.abs(org.charAt(st)-arr_t[st]);
                cost-= abs;
                st++;
            }

            if(cost<=maxCost){
                max = Math.max(max, ed-st+1);
            }
        }

        return max;

        
    }
}