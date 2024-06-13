// https://leetcode.com/problems/word-ladder

class Solution {
    
    int cnt=0;
    int[] res = new int[1];
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(beginWord.equals(endWord))
            return 0;
        
        if(!wordList.contains(endWord))
            return 0;
        
        res[0] = Integer.MAX_VALUE;
        
        Set<String> history  = new HashSet<>();
        history.add(beginWord);
        
      
        cnt++;
        
        helper(beginWord, endWord, wordList,  history);
        
        return res[0]==Integer.MAX_VALUE? 0 : res[0];
        
        
    }
    
    private void helper(String beginWord, String endWord, List<String> wordList, Set<String> history ){
            
        if(beginWord.equals(endWord)){
            res[0] = Math.min(res[0], cnt);
            return;
        }
        
        
        
        Set<String> candidate = findCandidate(beginWord, wordList, history);
        
        if(candidate.size()==0)
            return;
        
        
        for(String can : candidate){
            cnt++;
            history.add(can);
            helper(can, endWord, wordList, history);
            history.remove(history.size()-1);
            cnt--;
        }
            
    }
    
    
    
    private Set<String> findCandidate(String s, List<String> wordList, Set<String> history){
        Set<String> candidate = new HashSet<>();
        
        for(String word : wordList){
            int cnt=0;
            
            if(s.length()!=word.length() || history.contains(word))
                continue;
            
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=word.charAt(i))
                    cnt++;
                
                if(cnt>1)
                    break;
            }
            
            if(cnt==1)
                candidate.add(word);
        }
        
        return candidate;
    }
}