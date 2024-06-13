// https://leetcode.com/problems/k-th-symbol-in-grammar

class Solution {
    public int kthGrammar(int n, int k) {

			  // find
				return helper(n, k-1);
	
		// 	// base case
		// 	if(N==1) {
		// 		return 0;
		// 	}
				
		// 	if(K%2==1) {
		// 		return kthGrammar(N-1, (K+1)/2);
		// 	} else {
		// 		return flip(kthGrammar(N-1, K/2));
		// 	}
		// }
		}

		public int flip(int val) {
			return val==0? 1 : 0;
		}

public int helper(int n, int k){

    if(n==1)
			return 0;
		
		if(k%2==0){
				return helper(n-1, (k-1)/2);
		}else
				return flip(helper(n-1, (k-2)/2));

}
		}


//       a
// 2a+1    2a+2


// (k-1)/2+1,   (k-2)/2+1