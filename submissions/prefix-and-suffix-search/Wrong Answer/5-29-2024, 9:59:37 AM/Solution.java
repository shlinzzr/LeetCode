// https://leetcode.com/problems/prefix-and-suffix-search

class WordFilter {

    TrieNode preroot, sufroot;
    class TrieNode{

        
        TrieNode[] next = new TrieNode[26];
        boolean isWord =false;
        int idx;
        public TrieNode(){
            next = new TrieNode[26];
            isWord = false;
            idx= -1;
        }
        
    }

    public WordFilter(String[] words) {
        preroot = new TrieNode();
        sufroot = new TrieNode();

        for(int j = 0; j<words.length; j++){
            char[] arr = words[j].toCharArray();
            TrieNode curr = preroot;
            for(int i=0; i<arr.length; i++){
                char ch = arr[i];
                if(curr.next[ch-'a']==null){
                    curr.next[ch-'a']= new TrieNode();
                }
                curr = curr.next[ch-'a'];
                if(curr.idx==-1)
                    curr.idx = j;
            }
            curr.isWord=true;

            curr = sufroot;
            for(int i=arr.length-1; i>=0; i--){
                char ch = arr[i];
                if(curr.next[ch-'a']==null){
                    curr.next[ch-'a']= new TrieNode();
                }
                curr = curr.next[ch-'a'];
                if(curr.idx==-1)
                    curr.idx = j;
            }
            curr.isWord=true;
           
        }
    }
    
    public int f(String pref, String suff) {

        // System.out.println(preroot.next[0].idx);
        int a = Integer.MAX_VALUE;
        TrieNode curr = preroot;
        for(char ch : pref.toCharArray()){
            if(curr.next[ch-'a']==null){
                break;
            }
            curr = curr.next[ch-'a'];
        }
        a = curr.idx;

        curr = sufroot;

        int b = Integer.MAX_VALUE;
        for(char ch : suff.toCharArray()){
             if(curr.next[ch-'a']==null){
                break;
            }
            curr = curr.next[ch-'a'];
        }
        b = curr.idx;

        return Math.min(a,b)==Integer.MAX_VALUE ? -12 : Math.min(a,b);



        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */