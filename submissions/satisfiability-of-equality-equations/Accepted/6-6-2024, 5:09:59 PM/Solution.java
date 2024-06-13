// https://leetcode.com/problems/satisfiability-of-equality-equations

class Solution {

    int[] same;
    public boolean equationsPossible(String[] eq) {

        same = new int[26];
        for(int i=0; i<26; i++){
            same[i] = i;
        }

        int len = eq.length;
        for(String w : eq){
            int a = w.charAt(0)-'a';
            int b = w.charAt(3)-'a';

            char j = w.charAt(1);
            if(j=='='){
                union(a,b, same);
            }
        }

        for(String w : eq){
            int a = w.charAt(0)-'a';
            int b = w.charAt(3)-'a';
            char j = w.charAt(1);
            if(j=='!'){
                if(find(a, same)==find(b, same)) return false;
            }
        }

        return true;

        
    }

    private int find(int x, int[] parent){
        if(parent[x]!=x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private void union(int a, int b, int[] parent){

        a = find(a, parent);
        b = find(b, parent);

        if(a<b)
            parent[a] = b;
        else 
            parent[b] = a;

    }
}