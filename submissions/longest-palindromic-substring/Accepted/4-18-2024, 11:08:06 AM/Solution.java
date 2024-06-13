// https://leetcode.com/problems/longest-palindromic-substring

class Solution {

    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

// s = b a b a d
//     0 1 2 3 4 5 7 8 9 10 11
// T = ^ b # a # b # a #  d  $
//     C
//     R
//       i=1  R<=i : P[1] = 0, if(i + P[i] > R), update C and R
//       C=i
//       R=i + P[i]

//         i=2  R<=i : P[2] = 0, if(i + P[i] > R), update C and R
//         C=2
//         R=2

//           i=3  R<=i : P[3] = 0, expand 
// idx=0 1 2 3 4 5 7 8 9 10 11
// T = ^ b # a # b # a #  d  $
// P = 0 0 0 2 0 0 x x x  x  x     if(i + P[i] > R), update C and R
//           C=i
//               R=i+P[3]

//        mi=2 i=4 R>i : P[4] = Math.min(5-4, P[mirror_i]), // mirror_i = 2*C-i => 2*3-4 => 2




    // 马拉车算法 Manacher's algo : O(n)
    public String longestPalindrome(String s) {

        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n]; // record the longest Palindrome ans
        int C = 0, R = 0;

        // start from 1 skip to T.charAt(0)=='^', 
        // end before n-1 to skip T.charAt(n-1)=='$'
        for (int i = 1; i < n - 1; i++) { 
            int mirror_i = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[mirror_i]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }



    // expand O(n^2)
    // public String longestPalindrome(String s) {
        
    //     int len = s.length();
    //     String res = s.charAt(0)+"";

    //     for(int i=0; i<len; i++){

    //         String odd = expand(s, i, i);
    //         if(odd.length()>res.length()){
    //             res = odd;
    //         }

    //         if(i+1<len){
    //             String even = expand(s, i, i+1);
    //             if(even.length()>res.length()){
    //                 res = even;   
    //             }
    //         }
    //     }

    //     return res;

    // }
    // private String expand(String s , int i, int j){
        
    //     while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
    //         i--; 
    //         j++;
    //     }

    //     i++;
    //     j--;

    //     return s.substring(i, j+1);
    // }


// brute-force : O(n^2)

 // public String longestPalindrome(String s) {
        // String res = s.charAt(0)+"";

        // for(int i=0; i<len; i++){

        //     for(int j=i+2; j<=len; j++){
        //         String sub = s.substring(i, j);
        //         if(sub.length()<res.length()) continue;
        //         if(isPal(sub)){
        //             res = sub;
        //         }
        //     }
            
        // }

        // return res;
    // }

    private boolean isPal(String s){
        int len = s.length();

        for(int i=0; i<len/2; i++){

            int j = len-i-1;

            if(s.charAt(i)!=s.charAt(j))
                return false;
        }   

        return true;
    }
}