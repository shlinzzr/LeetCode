// https://leetcode.com/problems/word-ladder-ii

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord))
            return res;
        
        Queue<Tuple> q =new LinkedList<>();
        
        
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(new Tuple(beginWord, list));
        
        while(!q.isEmpty()){
            Tuple p = q.poll();
            
            if(p.list.size()>min)
                break;
            
            if(p.word.equals(endWord)){
                res.add(new ArrayList<>(p.list));
                min = Math.min(min, p.list.size());
            }
            
            
            String word = p.word;
            
            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z';ch++){
                    char[] temp = word.toCharArray();
                    temp[i]=ch;
                    if(set.contains(new String(temp))){
                        
                        p.list.add(new String(temp));
                        q.add(new Tuple(new String(temp), new ArrayList<>(p.list)));
                        set.remove(new String(temp));
                    }
                }
            }
        }
        
        return res;
    }
    
    class Tuple{
        String word;
        List<String> list;
        public Tuple(String word ,List<String> list){
            this.word = word;
            this.list = list;
        }
        
    }
}
