// https://leetcode.com/problems/determine-if-string-halves-are-alike

class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int mid = s.length()/2;
        int i=0,j=mid;
        int ans = 0;
        while(i<mid){
            if(vowels.indexOf(s.charAt(i)) >= 0)
                ans++;
            if(vowels.indexOf(s.charAt(j)) >= 0)
                ans--;
            i++;
            j++;
        }
        return ans==0;
    }
}