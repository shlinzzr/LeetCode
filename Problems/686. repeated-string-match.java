// https://leetcode.com/problems/repeated-string-match

class Solution {
    public int repeatedStringMatch(String a, String b) {

        int cnt=0;

        StringBuilder sb = new StringBuilder();
        while(sb.length()<b.length()){
            sb.append(a);
            cnt++;
        }

        if(sb.toString().contains(b))
            return cnt;

        sb.append(a);
        cnt++;

        if(sb.toString().contains(b))
            return cnt;



        return -1;


    }
}