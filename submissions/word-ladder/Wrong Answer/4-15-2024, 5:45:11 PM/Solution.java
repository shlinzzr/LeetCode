// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> seen = new HashSet<>();

        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        if(beginWord.equals(endWord))   
            return 1;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        seen.add(beginWord);
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){

                String cur = q.poll();
                System.out.println(cur + " " + step);

                if(cur.equals(endWord)) return step;

                char[] arr = cur.toCharArray();
                for(int i=0; i<cur.length(); i++){
                    for(char ch = 'a'; ch<='z'; ch++){
                        arr[i] = ch;
                        String next = new String(arr);
                        
                        if(wordSet.contains(next) && !seen.contains(next)){
                           
                            q.offer(next);
                            seen.add(next);
                        }
                    }
                }


                // for(String w : wordList){ // to avoid O(n) of wordList, we use 'a'-'z' to check adj
                //     if(seen.contains(w)) continue;

                //     int diff = 0;
                //     boolean valid = true;
                //     for(int i=0; i<w.length(); i++){
                //         if(w.charAt(i)!=cur.charAt(i)){
                //             diff++;
                //             if(diff>1){
                //                 valid = false;
                //                 break;
                //             }
                //         }
                //     }
                    
                //     if(!valid) continue;
                        
                //     seen.add(w);
                //     q.offer(w);
                // }
            }
            step++;
        }
        return 0;

        
    }
}