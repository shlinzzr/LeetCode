// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(beginWord,1));
        while(!q.isEmpty()){
            pair p=q.poll();
            if(p.s.equals(endWord)){
                return p.d;
            }
            String s=p.s;
            for(int i=0;i<s.length();i++){
                for(char a='a';a<='z';a++){
                    char temp[]=s.toCharArray();
                    temp[i]=a;
                    if(set.contains(new String(temp))){
                        q.add(new pair(new String(temp),p.d+1));
                        set.remove(new String(temp));
                    }
                }
            }
        }
        return 0;
    }
}
class pair{
    String s;
    int d;
    public pair(String t,int p){
        s=t;
        d=p;
    }
}