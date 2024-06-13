// https://leetcode.com/problems/concatenated-words

class Solution {	 
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
   
        //sort the array in asc order of word length, since longer words are formed by shorter words.
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        List<String> result = new ArrayList<>();
        
        //list of shorter words 
        HashSet<String> preWords = new HashSet<>();
        
        for(int i=0; i< words.length; i++){
            //Word Break-I problem.
            if(wordBreak(words[i], preWords)) result.add(words[i]);
            preWords.add(words[i]);
        }
        return result;
    }

     public boolean wordBreak(String s, Set<String> set) {

        Set<Integer> lenSet= new HashSet<>();
        for(String w : set){
            lenSet.add(w.length());
        }

        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        for(int i=1; i<=len; i++){
            for(int wLen : lenSet){
                if(i-1+wLen<=len){
                    String sub = s.substring(i-1, i-1+wLen);
                    if(dp[i-1] && set.contains( sub )){
                        dp[i-1+wLen]=true;
                    }
                }
            }
        }


        return dp[len];
    }
    
    private boolean wordBreak(String s, HashSet<String> preWords){
        if(preWords.isEmpty()) return false;
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && preWords.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}