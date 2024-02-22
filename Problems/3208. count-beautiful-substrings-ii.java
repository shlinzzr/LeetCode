// https://leetcode.com/problems/count-beautiful-substrings-ii

class Solution {
       public long beautifulSubstrings(String s, int k) {
        int n = s.length(), v = 0, left;
        for (left = 1; left * left % (k * 4) > 0; ++left);
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        HashMap<Integer, Integer>[] seen = new HashMap[left];
        for (int i = 0; i < left; i++) {
            seen[i] = new HashMap<>();
        }
        seen[left - 1].put(0, 1);
        long res = 0;
        for (int i = 0; i < n; i++) {
            v += vowels.contains(s.charAt(i)) ? 1: -1;
            int c = seen[i % left].getOrDefault(v, 0);
            res += c;
            seen[i % left].put(v, c + 1);
        }
        return res;
    }
}