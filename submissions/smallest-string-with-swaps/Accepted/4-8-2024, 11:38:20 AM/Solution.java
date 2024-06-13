// https://leetcode.com/problems/smallest-string-with-swaps

class Solution {

    int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int len = s.length();

        parent = new int[len];
        for(int i=0; i<len; i++){
            parent[i] = i;
        }

        for(List<Integer> p : pairs){
            union(p.get(0), p.get(1));
        }

        Map<Integer, List<Character>> map = new HashMap<>(); // root -> all children idx


        for(int i=0; i<len; i++){

            int root = find(i);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(s.charAt(i));
        }

        for(int k : map.keySet()){
            Collections.sort(map.get(k));
        }

        StringBuilder sb = new StringBuilder();
        for(int i= 0; i<len;i++){
            char ch = map.get(find(i)).remove(0);
            sb.append(ch);
        }

        return sb.toString();



    }


    private int find( int x){
        if(parent[x]!=x) 
            parent[x]= find(parent[x]);
        return parent[x];
    }

    private void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a==b) return ;

        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
}