// https://leetcode.com/problems/k-th-symbol-in-grammar

class Solution {
    public int kthGrammar(int N, int K) {
	
			// base case
			if(N==1) {
				return 0;
			}
				
			if(K%2==1) {
				return kthGrammar(N-1, (K+1)/2);
			} else {
				return flip(kthGrammar(N-1, K/2));
			}
		}

		public int flip(int val) {
			return val==0? 1 : 0;
		}
}