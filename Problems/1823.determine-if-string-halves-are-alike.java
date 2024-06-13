// https://leetcode.com/problems/determine-if-string-halves-are-alike

class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String a = s.substring(0, len/2);
        String b = s.substring(len/2, len);
        Character[] arr = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> list = Arrays.asList(arr);
        Set<Character> set = new HashSet<>(list);


        int cnta=0,cntb=0;
        for(int i=0; i<len/2; i++){
            if(set.contains(a.charAt(i)))
                cnta++;
            if(set.contains(b.charAt(i)))
                cntb++;
        }

        return cnta==cntb;

    }
}