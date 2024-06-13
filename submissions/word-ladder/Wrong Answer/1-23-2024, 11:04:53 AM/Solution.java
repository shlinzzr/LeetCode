// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord)) return 0;
        if(beginWord.equals(endWord)) return 0;
        if(beginWord.length()!=endWord.length()) return 0;
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        
        int step = 1;
        while(!q.isEmpty()){
            
            int siz = q.size();
            while(siz-->0){
                
                String p = q.poll();
                
                if(p.equals(endWord)) return step;
                
                List<String> list = getNeb(p, wordList);
                
                for(String next : list){
                    if(seen.contains(next)) continue;
                    q.offer(next);
                    seen.add(next);
                }
            }
            step++;
        }
        
        return step;
        
        
        
    }
    
    private List<String> getNeb(String p, List<String> wordList){
        List<String> res = new ArrayList<>();
        
        for(String w : wordList){
            
            int diff = 0;
            for(int i=0; i<p.length(); i++){
                if(w.length()!=p.length())
                    continue;
                if(w.charAt(i)!=p.charAt(i))
                    diff++;
            }
            
            if(diff==1) res.add(w);
        }
        
        return res;
        
        
    }
}