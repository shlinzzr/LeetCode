// https://leetcode.com/problems/similar-string-groups

class Solution {

    int[] parent;
    public int numSimilarGroups(String[] strs) {

        int len = strs.length;
        parent = new int[len];
        for(int i=0; i<len; i++){
            parent[i] = i;
        }
        int res = len;

        for(int k=0; k<len; k++){
            for(int i=0; i<len; i++){
                for(int j=i+1; j<len; j++){

                    if(union(i, j, strs)){
                        res--;
                    }
                }
            }
        }
        return res;
        


        
    }

    private boolean union(int i, int j, String[] arr){
        if(isSim(arr[i], arr[j])==false) return false;

        int a = find(i);
        int b = find(j);
        if(a==b) return false;

        if(a<b) parent[b]=a;
        else parent[a]=b;

        return true;


    }

    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }


    private boolean isSim(String a, String b){
        if(a.equals(b)) return true;
        int diff = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
            }
            if(diff>2) return false;
        }
        return true;
    }
}