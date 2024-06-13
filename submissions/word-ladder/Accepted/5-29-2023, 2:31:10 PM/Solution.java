// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(beginWord.length()!=endWord.length())
            return 0;
        
        if(!wordList.contains(endWord))
            return 0;
        
        Queue<String> q = new LinkedList<>();
        boolean[] bool = new boolean[wordList.size()];
        
        q.offer(beginWord);
        
        int step = 2;
        
        while(!q.isEmpty()){
            
            for(int j=q.size(); j>0; j--){ // loop step
                
                String p = q.poll();
                for(int i=0; i<wordList.size(); i++){

                    String next = wordList.get(i);
                    
                    if(bool[i] || p.length()!=next.length())
                        continue;

                    int diff = 0;    
                    boolean add = true;
                    for(int k=0; k<p.length(); k++){
                        if(p.charAt(k)!=next.charAt(k)){

                            if(diff==0)
                                diff++;
                            else{
                                add = false;
                                break;
                            }
                        }
                    }
                    
                    if(add==false)
                        continue;
                    
                    if(endWord.equals(next))
                        return step;
                    // System.out.println(p + "->" + next);
                    q.offer(next);
                    bool[i]=true;
                }
            }
            // System.out.println();
            step++;
            
            
        }
        return 0;
        
    }
}