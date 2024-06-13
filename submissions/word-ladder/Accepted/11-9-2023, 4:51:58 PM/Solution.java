// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;

        if(beginWord.length()!=endWord.length() )
            return 0;

        if(beginWord.equals(endWord))
            return 1;

        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step=1;

        

        while(!q.isEmpty()){

            int siz=q.size();
            while(siz-->0){

                String p = q.poll();

                for(int i=0; i<p.length(); i++){

                    char[] arr = p.toCharArray();

                    for(int j=0; j<26; j++){
                        arr[i] = (char) (j+'a');

                        String t = new String(arr);

                        if(t.equals(endWord))
                            return step+1;

                        if(set.contains(t) && !seen.contains(t)){
                            seen.add(t);
                            q.offer(t);
                        }
                    }
                }
            }
            step++;
        }

        return 0;
    }
}