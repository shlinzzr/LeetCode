// https://leetcode.com/problems/count-the-number-of-beautiful-subarrays

class Solution {
    public long beautifulSubarrays(int[] nums) {

        // 10^6 == 2^20
    //     // 1. sliding window
    //     // 2. presum + hashmap
    // 分開看的話就是 走到k的時候loop i , j 找到滿足下面條件
    // 但是nums.length==10^5,因此O(n^2)不可能
    //     2*presum[j]-presum[i-1] == presum[k]
    //          i     j.       k   
    //  xxx  |  x     x    x   x | x x x
    //        0100 0010   0110
    //     a. k=0100
    //     b. k=0010

    //     presum :
    //     0100 0110 0110


        // 翻譯: 找出一個subarray 他的每個bit==1個數相加起來是偶數 (才有可能i j同時減掉)
        // 用state 紀錄 **********01  req : 出現偶數次1
        
        HashMap<Long, Integer> map = new HashMap<>(); // state, 出現次數
        map.put(0L, 1);
        
        long prexor = 0;
        long res = 0;
        for (int a : nums) {
            prexor ^= a;  //每個bit 要不0次 要不就是1次
            int v = map.getOrDefault(prexor, 0);  // 曾經出現的話表示 他們之間一定是偶數個bit
            res += v;
            //出現過表示 x x x x x [ x x x ] 
            //                 i       j
            //               state    state
            //                    ^^^^^^^^ 這段一定是偶數個bit
            map.put(prexor, v + 1);
        }
        return res;



        






        
    }
}