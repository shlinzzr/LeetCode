// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
        
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            
            if(p.word.equals(endWord)){
                return p.step;
            }
            
            String word=p.word;
            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z';ch++){
                    char[] temp = word.toCharArray();
                    temp[i]=ch;
                    if(set.contains(new String(temp))){
                        q.add(new Pair(new String(temp),p.step+1));
                        set.remove(new String(temp));
                    }
                }
            }
        }
        return 0;
    }
    
    class Pair{
        String word;
        int step;
        public Pair(String word ,int step){
            this.word=word;
            this.step = step;
        }
    }
    
}
