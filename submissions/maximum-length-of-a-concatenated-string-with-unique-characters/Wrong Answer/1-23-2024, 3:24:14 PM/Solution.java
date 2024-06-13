// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

class Solution {

    int[] parent;
    int[] weight;

    public int maxLength(List<String> arr) {

        int len = arr.size();
        parent = new int[len];
        weight = new int[len];

        for(int i=0;i<len; i++){
            parent[i] = i;
            weight[i] = arr.get(i).length();
        }

        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){

                String a = arr.get(i);
                String b = arr.get(j);

                int[] charr = new int[26];
                for(char cha : a.toCharArray()){

                    if(charr[cha-'a']>0){
                        weight[i]=0;
                    }
                    charr[cha-'a']++;
                }
                boolean merge=false;

                int[] chbrr = new int[26];
                for(char chb : b.toCharArray()){
                    
                    if(chbrr[chb-'a']>0){
                        weight[j]=0;
                    }

                    if(charr[chb-'a']>0){
                        merge=true;                        
                    }
                    chbrr[chb-'a']++;
                }

                if(merge){
                    union(i, j);
                }
            }
        }

        int res = 0;
        for(int i=0; i<len; i++){
            // System.out.println(i + " " + parent[i]);
            if(parent[i]==i){
                res+= weight[i];
            }
        }

        return res;
    }

    private int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return ;

        if(weight[a]>=weight[b]){
            parent[b] = a;
            weight[b] = weight[a];

        }else{
            parent[a] = b;
            weight[a] = weight[b];
        }
    }
}