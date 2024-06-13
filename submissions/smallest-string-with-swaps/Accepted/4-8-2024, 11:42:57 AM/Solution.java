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

        Map<Integer, List<Integer>> map = new HashMap<>(); // root -> all children idx


        for(int i=0; i<len; i++){

            int root = find(i);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(i);
        }

        char[] arr = s.toCharArray();

        for(List<Integer> idxs : map.values()){
            List<Character> list = new ArrayList<>();
            for(int idx : idxs){
                list.add(s.charAt(idx));
            }

            Collections.sort(list);
            
            for(int i =0; i<idxs.size(); i++){
                arr[idxs.get(i)] = list.get(i);   
            }


        }

        return new String(arr);



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