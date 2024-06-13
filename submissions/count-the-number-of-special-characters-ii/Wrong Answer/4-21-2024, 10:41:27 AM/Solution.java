// https://leetcode.com/problems/count-the-number-of-special-characters-ii

class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
          Set<Character> nonspe = new HashSet<>();
        
        
          Set<Character> isspe = new HashSet<>();
        
        for(char ch : word.toCharArray()){
            
            // if(ch>='a' && ch<='z') isspe.add(ch);
            
            if(ch>='A' && ch<='Z'){
                
                int idx= ch-'A';
                
                if(!map.containsKey((char)(idx+'a')))
                    nonspe.add(ch);
                
            }
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        
         for(int i=0; i<26; i++){
            char cha = (char) ('a'+i);
            char chA =  (char) ('A'+i);
            
            if(map.containsKey(cha) && map.containsKey(chA) && !nonspe.contains(chA)) res++;
         }
        
        return res;
        
        
    }
}