// https://leetcode.com/problems/word-ladder-ii

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>>  res =new ArrayList<>();
        Set<String> set= new HashSet<>(wordList);
        if(!set.contains(endWord))
            return res;

        if(beginWord.length()!=endWord.length() )
            return res;

        List<String> ini = new ArrayList<>();
        ini.add(beginWord);
        

        if(beginWord.equals(endWord)){
            res.add(ini);
            return res;
        }
            

        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        Queue<List<String>> q = new LinkedList<>();
        
        q.offer(ini);
        int step=1;

        

        while(!q.isEmpty()){

            int siz=q.size();
            while(siz-->0){

                List<String> list = q.poll();
                String p = list.get(list.size()-1);
                
                List<String> neighbors = getNeighbors(p, set);
                for (String neb : neighbors) {
                    List<String> tmp = new ArrayList<>(list);
                    tmp.add(neb);
                    seen.add(neb);
                    if (neb.equals(endWord)) {
                        res.add(tmp);
                    } else {
                        q.offer(tmp);
                }
            }
            for (String s : seen)   // remove used words from wordSet to avoid going back
                set.remove(s);
            }

        }

        return res;
    }

     private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] ch = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                ch[i] = c;
                String str = new String(ch);
                if (wordSet.contains(str))  // only get valid neighbors
                    neighbors.add(str);
            }
        }
        return neighbors;
    }
}