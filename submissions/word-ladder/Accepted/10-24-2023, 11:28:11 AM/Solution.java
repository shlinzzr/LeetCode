// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord))
            return 0;

        if(beginWord.length()!=endWord.length())
            return 0;

        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        seen.add(beginWord);

        int step=2;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String curr = q.poll();

                for(String next : wordList){

                    if(seen.contains(next) || next.length()!=curr.length())
                        continue;
                    
                    boolean isCandiate = true;
                    int diff = 0;
                    for(int i=0; i<next.length(); i++){
                        if(curr.charAt(i)!=next.charAt(i)){
                            if(diff==0){
                                diff++;
                            }else{
                                isCandiate=false;
                                break;
                            }
                        }
                    }

                    if(!isCandiate)
                        continue;

                    if(next.equals(endWord))
                        return step;

                    q.offer(next);
                    seen.add(next);

                 
                }
            }
            step++;
        }

        return 0;
    }
}