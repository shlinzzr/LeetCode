// https://leetcode.com/problems/find-the-k-th-lucky-number

class Solution {
    public String kthLuckyNumber(int k) {
	var sb = new StringBuilder();
	while (k>0){
		sb.append((k%2==1)?'4':'7');
		k=(k-1)/2;
	}
	return sb.reverse().toString();
}
}