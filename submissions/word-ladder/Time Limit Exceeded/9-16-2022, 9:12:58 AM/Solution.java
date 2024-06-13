// https://leetcode.com/problems/word-ladder

class Solution {
    
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(beginWord.equals(endWord))
            return 0;
        
        if(!wordList.contains(endWord))
            return 0;

        
        return helper(beginWord, endWord, wordList);
        
        
    }
    
    private int helper(String beginWord, String endWord, List<String> wordList){
        // System.out.println("\nbeginWord="+beginWord+ " cnt="+cnt);
        
        Set<String> history  = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int cnt=0;
        
        while(!queue.isEmpty()){
            cnt++;  
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String str = queue.poll();
                
                if(str.equals(endWord))
                    return cnt;
                
                history.add(beginWord);

                Set<String> candidate = findCandidate(str, wordList, history);
                for(String can : candidate){
                       queue.offer(can); 
                } 
            }
        }
            
        return 0;
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