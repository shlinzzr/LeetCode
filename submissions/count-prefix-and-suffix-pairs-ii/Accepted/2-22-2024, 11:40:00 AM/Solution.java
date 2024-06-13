// https://leetcode.com/problems/count-prefix-and-suffix-pairs-ii

class Solution {
    
    public long countPrefixSuffixPairs(String [] words) {
        long res = 0;
        HashMap<String, Integer> cnt = new HashMap<>();
        for (String s : words) {
            for (String key : cnt.keySet())
                if (s.startsWith(key) && s.endsWith(key))
                    res += cnt.get(key);
            cnt.merge(s, 1, Integer::sum);
        }
        return res;
    }


}  
    