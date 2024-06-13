// https://leetcode.com/problems/encode-number

class Solution {
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}

/*

f(5) = "10"
f(6) = "11"
The prefix are both f(2) = "1"

so we found that f(n) has f((n - 1) / 2) as prefix.




Assume g(n) = "1" + f(n)
we can find:
g(0) = "1" g(1) = "10" g(2) = "111" g(3) = "100" g(4) = "101" g(5) = "110" g(6) = "111"

Now everything is obvious:
g(n) = binary(n + 1)
"1" + f(n) = binary(n + 1)
f(n) = binary(n + 1).substring(1)

*/