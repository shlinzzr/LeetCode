// https://leetcode.com/problems/find-substring-with-given-hash-value

class Solution {

    public String subStrHash(String s, int power, int mod, int k, int hashValue) {
		long hash = 0;
		long powerk = 1;
		int n = s.length();
		int res = 0;
		for (int i = n - 1; i >= 0; i--) {
			hash = (hash * power + s.charAt(i) - 'a' + 1) % mod;
			if (i + k >= n) { // init power^k-1
				powerk = powerk * power % mod;

			} else { // delete last
				hash -= ((s.charAt(i + k) - 'a' + 1) * powerk) % mod ;
                hash  = (hash + mod) % mod;
			}
			if (hash == hashValue) {
				res = i;
			}
		}
		return s.substring(res, res + k);
	}
    
    /*
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {

        int len = s.length();

        String sub = s.substring(len-k, len);
        long val = hash(sub, power, modulo);

        for(int st = len-k-1; st>=0; st--){

            int ed = st+k;

            //remove st
            // val += modulo;
            val -= (s.charAt(ed)-'a'+1) * Math.pow(power, k-1)%modulo;
            val = (val + modulo)%modulo;

            val = val * power % modulo;
            val = (val + (s.charAt(st)-'a'+1) )%modulo;

            if(val==hashValue)
                return s.substring(st, ed+1);

        }

        return "not good";
        
    }*/

}