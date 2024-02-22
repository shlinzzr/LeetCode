// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new  HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int cur = 0;
        int max = 0;
        int st= 0;
        for(int ed=0; ed<s.length(); ed++){
            
            if(set.contains(s.charAt(ed)))
                cur++;
            
            if(ed-st+1<k)
                continue;
            
            max = Math.max(max, cur);
            
            if(set.contains(s.charAt(st++)))
                cur--;
            
            
        }
        return max;
    }
}
