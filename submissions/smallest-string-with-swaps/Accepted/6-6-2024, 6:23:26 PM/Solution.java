// https://leetcode.com/problems/smallest-string-with-swaps

class Solution {
    int[] parent;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int len = s.length();
        parent = new int[len];
        for(int i=0; i<len;i++){
            parent[i] = i;
        }

        
        for(List<Integer> p : pairs){
            int a = find(p.get(0));
            int b = find(p.get(1));
            union(a,b);
        }

        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int root = find(i);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(ch);
        }

        // sorting
        for(List<Character> list : map.values())
            Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            int root = find(i);
            sb.append(map.get(root).remove(0));
        }

        return sb.toString();






    }

    private boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return false;
        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }

        return true;
        
    }


    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }

}