// https://leetcode.com/problems/can-make-palindrome-from-substring

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        List<Boolean> res = new ArrayList<>();
        int len = s.length();

        for(int i=0; i<queries.length;i ++){
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];

            res.add(isPal(s, left, right, k));
        }

        return res;
        
    }

    private boolean isPal(String s, int st, int ed, int k){
        

        while(st<ed){
            if(s.charAt(st)==s.charAt(ed)){
                st++;
                ed--;
                continue;
            }else{

                if(k==0) return false;
                k--;
                st++;
                ed--;
            }
        }
        return true;
    }
}