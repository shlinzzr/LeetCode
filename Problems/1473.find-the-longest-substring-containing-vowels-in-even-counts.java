// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts

class Solution {
    public int findTheLongestSubstring(String s) {

        int len = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);


        int state = 0; // aeiou
        int res = 0;

        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        int max= 0 ;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            int idx = ch-'a';

            
            for(int j=0; j<5; j++){
                char vowel = list.get(j);
                if(vowel==ch){
                    state ^= (1<<j);
                    break;
                }
            }

            if(!map.containsKey(state)){
                map.put(state, i);
            }else{
                max = Math.max(max, i-map.get(state));
            }
            


        }

        return max;


        
    }
}