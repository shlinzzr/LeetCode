// https://leetcode.com/problems/find-the-k-th-lucky-number

class Solution {
    public String kthLuckyNumber(int k) {

        // 4, 7, 44, 47, 74, 
        // 0, 1, 00, 01, 10, 11 ...
        // 2^1, +  2^2,+  2^3 + ...

        // 2 + 4 + 8 + 16 + ...

        // N=1 N=2
        // N=1 : 2^(N+1)-2
        // N=2 : 2^(2+1)-2= 6
        //

        // find the first N s.t.   2^(N+1)-2 > k

        // long state = 0L
        // 1010010100001 個
        //
        StringBuilder sb = new StringBuilder();
        while(k>0){

            if(k%2==0){
                
            }

        }
        int n = find(k);

        for(int )






        
    }

    private int find(int k){
        int st=0, ed =30;

        while(st<ed){ // 0, 1
            int mid = st+(ed-st)/2; // 0
            int val = Math.pow(2, mid+1)-2;

            if(val==k){
                return mid;

            }else if(val>k){
                ed = mid; 
            }else {
                st = mid+1;
            }
        }

        return st;

    }
}