// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        if(beginWord.length()!=endWord.length()) return 0;

        Queue<String> q= new LinkedList<>();
        q.offer(beginWord);


        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){
                String p = q.poll();

                if(p.equals(endWord)) return step;

                List<String> adjs = getNext(set, p);
                for(String next : adjs){
                    if(seen.contains(next)) continue;

                    q.offer(next);
                    seen.add(next);
                }

                // for(int i=0; i<arr.length; i++){
                //     char org = arr[i];
                //     for(char ch='a'; ch<='z';ch++){
                //         arr[i] = ch;
                //         String next = new String(arr);
                //         if(set.contains(next) && !seen.contains(next)){
                //             q.offer(next);
                //             seen.add(next);
                //         }   
                //     }
                //     arr[i]=org;
                // }



            }
            step++;
        }
        return 0;
    }


    private List<String> getNext(Set<String> set , String curr){

        List<String> res = new ArrayList<>();

        for(String s : set){
            if(s.length()!=curr.length()) continue;
            int diff = 0;
            boolean match = true;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=curr.charAt(i))
                    diff++;
                if(diff>1){
                    match = false;
                    break;
                } 
            }

            if(match) res.add(s);
        }

        return res;

    }
}