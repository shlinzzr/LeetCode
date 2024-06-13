// https://leetcode.com/problems/counting-bits

// class Solution {
    
//     //https://leetcode.com/problems/counting-bits/discuss/270693/Intermediate-processsolution-for-the-most-voted-solution-i.e.-no-simplificationtrick-hidden
    
    
//     // dp => 9ms
//     public int[] countBits(int num) {
//         int[] res = new int[num + 1];
//         res[0] = 0;
        
//         for(int i = 1; i <= num; i++){
//             if((i & 1) == 0){
//                 res[i] = res[i >> 1]; // f(n) = f(n/2) + n%2
//                                       //       when n%2==0 /. n%2==1
//                                       // f(n) =
//             }else{
//                 res[i] = res[i - 1] + 1;
//             }
//         }
//         return res;
//     }
// }

// formula 1ms
class Solution {
  public int[] countBits(int n) {
    // let f(i) := i's # of 1's in bitmask
    // f(i) = f(i / 2) + i % 2
    int[] ans = new int[n + 1];

    for (int i = 1; i <= n; ++i)
      ans[i] = ans[i / 2] + (i % 2 == 0 ? 0 : 1);

    return ans;
  }
}