// https://leetcode.com/problems/reverse-integer

// class Solution {
//     public int reverse(int x) {
//         long res = 0;
//         while (x != 0) {
//             res *= 10;
//             res += x % 10;
//             x /= 10;
//         }
//         return (int)res == res ? (int)res : 0;
//     }
// }


class Solution {
    public int reverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}