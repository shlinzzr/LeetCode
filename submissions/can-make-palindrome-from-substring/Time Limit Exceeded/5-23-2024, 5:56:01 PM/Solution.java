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

        int[] arr = new int[26];
        int single = 0;

        for(int i=st;i<=ed; i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i=0; i<26; i++){
            if(arr[i]%2==1) 
            {
                single++;
            }
        }

        if(single==1) return true;

        return 2*k>=(single-1);
        

        // while(st<ed){
        //     if(s.charAt(st)==s.charAt(ed)){
        //         st++;
        //         ed--;
        //         continue;
        //     }else{

        //         if(k==0) return false;
        //         k--;
        //         st++;
        //         ed--;
        //     }
        // }
        // return true;
    }
}