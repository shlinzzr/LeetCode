// https://leetcode.com/problems/word-ladder-ii

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return res;
        
        Queue<Tuple> q = new LinkedList<>();
        
        
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        set.remove(beginWord);
        q.add(new Tuple(beginWord, list, set));
        
        while(!q.isEmpty()){
//             System.out.print("q= "); 
//             for(Tuple tu : q ){
//                 System.out.print(tu.word + " , ");
//             }
            
//             System.out.println( " sz="  + q.size());
            
            Tuple p = q.poll();
            
//              System.out.print("word=" + p.word + " list:" );
//             for(String l : p.list){
//                 System.out.print(l + ", ");
//             }
//             System.out.println();
            
            
            
            
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
                    if(p.set.contains(new String(temp))){
                        
                        Tuple next = new Tuple(new String(temp), new ArrayList<>(p.list), new HashSet<>(p.set));
                        next.list.add(new String(temp));
                        next.set.remove(new String(temp));
                        q.add(next);
                    }
                }
            }
            
          
        }
        
        return res;
    }
    
    class Tuple{
        String word;
        List<String> list;
        Set<String> set;
        
        public Tuple(String word ,List<String> list, Set<String> set){
            this.word = word;
            this.list = list;
            this.set = set;
        }
        
    }
}
