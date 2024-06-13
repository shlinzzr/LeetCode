// https://leetcode.com/problems/lexicographically-smallest-equivalent-string

class Solution {
    int[] parent = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        int len = s1.length();

        for(int i=0; i<26; i++){
            parent[i]=i;
        }

        for(int i=0; i<len; i++){
            int a = s1.charAt(i)-'a';
            int b = s2.charAt(i)-'a';
            union(a, b);
        }

        char[] arr = baseStr.toCharArray();
        for(int i=0; i<baseStr.length(); i++){
            int x  = baseStr.charAt(i)-'a';

            arr[i] = (char)(find(x)+'a');
        }

        return new String(arr);



        
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return ;

        if(a<b){
            parent[b]=a;

        }else{
            parent[a] = b;
        }
    }

    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
}