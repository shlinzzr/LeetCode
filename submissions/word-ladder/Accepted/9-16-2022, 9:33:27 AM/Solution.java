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
        System.out.println("\nbeginWord="+beginWord);
        
        
        Set<String> set = new HashSet<>(wordList);
        Set<String> history  = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int cnt=0;
        
        while(!queue.isEmpty()){
            cnt++;  
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                
                if(word.equals(endWord))
                    return cnt;

                // Set<String> candidate = findCandidate(str, wordList, history);
                // for(String can : candidate){
                //        queue.offer(can); 
                // } 
                
                for(int j = 0; j < word.length(); j++){
                    for(int k = 'a'; k <= 'z'; k++){
                        char arr[] = word.toCharArray();
                        arr[j] = (char) k;
                        
                        String str = new String(arr);
                        if(set.contains(str) && !history.contains(str)){
                            queue.add(str);
                            history.add(str);
                        }
                    }
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